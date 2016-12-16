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
import com.google.appengine.labs.repackaged.org.json.JSONObject;


import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/elink")
public class Register {
	@GET
    
	public String abc()
	{
		Map<String, String> properties = new HashMap();

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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
		        "Demo", properties);
		EntityManager em = emf.createEntityManager();
		/*
	    em.getTransaction().begin();
	    em.persist(new Student(22,"sumukh"));
	   
	    em.getTransaction().commit();
	    em.close();*/
	    
	    String ans=null;
	    em = emf.createEntityManager();
	    em.getTransaction().begin();
	    List<Student> result = em
	        .createQuery("SELECT g FROM Student g")
	        .getResultList();
	    for (Student g : result) {
	     	      ans+=    g.getAge() + " " + g.getName() + " ";
	         
	    }
	   // System.out.println("answer "  + ans);
	    em.getTransaction().commit();
	    em.close();
		
	    return "Working";
	}
	
	
	@GET
	@Path("add_google_user")
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
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(
	        "Demo", properties);
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	Query query = em.createQuery("SELECT count(g) FROM User_login g WHERE g.email= :mail");
	query.setParameter("mail", email);
	Long row_count = (Long) query.getSingleResult() ;
	status+= "row count is" + row_count;
	em.getTransaction().commit();
    em.close();
    EntityManager em1 = emf.createEntityManager();
	try
	{
	    status+="entered try";	
		// Check if user already exists.
		if(row_count==0)
		{ 	
			//status+= user.getEmail() ;
			
			em1.getTransaction().begin();
			em1.persist(new User_login(name,email,password));
			em1.getTransaction().commit();
			
			status+="entered try part 2 query";
			em1.getTransaction().begin();
			Query query1 = em1.createNativeQuery("select user_id from users_login order by user_id desc limit 1");
			Long userid = (Long) query1.getSingleResult() ;
			status+="elast insert id" + userid;
			em1.getTransaction().commit();
			
			
			status = "User succesfully signed up!" + ":" + userid  + ":"  + name;
		}
		else
			status = "User already exists!";
			
    }
	
	catch (Exception e)
	{
		status += e.getMessage(); 
	}
	
	finally{
    em1.close();
	}
  
	return status;
		 
	}
	
	/*
	@GET
	@Path("add_user")
	
	public String add_user(@QueryParam("name") String name,@QueryParam("email") String email, @QueryParam("password") String password)
	{
		Map<String, String> properties = new HashMap();
        String status="";
	    if (SystemProperty.environment.value() ==
	          SystemProperty.Environment.Value.Production) {
	      //properties.put("javax.persistence.jdbc.driver",
	        //  "com.mysql.jdbc.GoogleDriver");
	      //properties.put("javax.persistence.jdbc.url",
	        //  System.getProperty("cloudsql.url"));
	    } 
	    else
	    {
	      properties.put("javax.persistence.jdbc.driver",
	          "com.mysql.jdbc.Driver");
	      properties.put("javax.persistence.jdbc.url",
	          System.getProperty("local.cloud.connection"));
	    }
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Demo", properties);
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	Query query = em.createQuery("SELECT count(g) FROM User_login g WHERE g.email= :mail");
	query.setParameter("mail", email);
	Long row_count = (Long) query.getSingleResult() ;
	em.getTransaction().commit();
    em.close();
    EntityManager em1 = emf.createEntityManager();
	try
	{
		
		// Check if user already exists.
		if(row_count==0)
		{ 	
			//status+= user.getEmail() ;
			
			em1.getTransaction().begin();
			em1.persist(new User_login(name,email,password));
			em1.getTransaction().commit();
			status = "User succesfully signed up!";
		}
		else
			status = "User already exists!";
			
    }
	
	catch (Exception e)
	{
		status += e.getMessage(); 
	}
	
	finally{
    em1.close();
	}
	return "{\"msg\":\"" + status + "\"}";
		 
	}
	
	
	
	
	
	*/
	
	

}
