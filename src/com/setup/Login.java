package com.setup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.google.appengine.api.utils.SystemProperty;
import java.util.HashMap;
import java.util.Map;

@Path("/login")
public class Login {
	
	@GET
	@Path("verify_user")
	public String add_google_user(@QueryParam("name") String name,@QueryParam("email") String email, @QueryParam("password") String password)
	{
		Map<String, String> properties = new HashMap();
        String status=null;
	if (SystemProperty.environment.value() ==
	          SystemProperty.Environment.Value.Production) {
	      //properties.put("javax.persistence.jdbc.driver",
	        //  "com.mysql.jdbc.GoogleDriver");
	      //properties.put("javax.persistence.jdbc.url",
	        //  System.getProperty("cloudsql.url"));
	    } else {
	      properties.put("javax.persistence.jdbc.driver",
	          "com.mysql.jdbc.Driver");
	      properties.put("javax.persistence.jdbc.url",
	          System.getProperty("local.cloud.connection"));
	    }
	
	// check if normal user/ google user
	
	boolean normal = true; //assume normal user
	if(password == null)
		normal = false;
	
	//if google user, check only email id else check both email and password
	
	
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Demo", properties);
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	Query query1 = em.createQuery("SELECT count(g) FROM User_login g WHERE g.email= :mail");
	query1.setParameter("mail", email);
	Long row_count = (Long) query1.getSingleResult() ;
	em.getTransaction().commit();
    //em.close();
	
	
	
	try{
	em.getTransaction().begin();
	Query query = em.createQuery("SELECT g FROM User_login g WHERE g.email= :mail");
	query.setParameter("mail", email);
	User_login user =  (User_login) query.getSingleResult() ;
	if(normal == false)  //google user, check email
	{
		if(row_count==1)
		{
			status =  user.getUser_name() + ":" + user.getUser_id();
		}
		else
		{
			status = "Not valid guser";
		}
	}
	else
	{
		if(row_count==1)
		{
		  if(user.getPassword().equals(password))
			  status = user.getUser_name() + ":"  + user.getUser_id();   //create authentication token
		  else
			  status= "Sorry wrong password. Try again!!" ;
		}
		else
		{
			status = "Not valid user";	
		}
	}
	em.getTransaction().commit();
	}
   
	catch (Exception e)
	{
		status += e.getMessage(); 
	}
	
	finally{
    em.close();
	}
  
	return status;
		 
	}

	
	

}
