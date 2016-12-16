package com.jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.api.utils.SystemProperty;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/elink")
public class Eclipselinktest {
	@GET
    @Produces({MediaType.APPLICATION_JSON})
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
		
	    return ans;
	}

}
