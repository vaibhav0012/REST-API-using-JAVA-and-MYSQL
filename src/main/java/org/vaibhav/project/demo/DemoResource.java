package org.vaibhav.project.demo;

//import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/demo")
public class DemoResource {
	
	DemoRepositary repo = new DemoRepositary();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Demo> getDemo()
	{
		
		return repo.getDemo();
	}
	
	@GET
	@Path("demo1/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Demo getDemo1(@PathParam("id") int ID)
	{
		
		return repo.getDemo(ID);
	}
	@POST
	@Path("demo1")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Demo create(Demo a)
	{
		System.out.println(a);
		repo.create(a);
		return a;
	}
	
	@PUT
	@Path("demo1")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Demo update(Demo a)
	{
		System.out.println(a);
		if(repo.getDemo(a.getID()).getID()==0)
		{
			repo.create(a);
		}
		else
		{
			repo.update(a);
		}
		return a;
	}
	
	@DELETE
	@Path("demo1/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void DeleteDemo1(@PathParam("id") int ID)
	{
		Demo a = repo.getDemo(ID);
		
		if(a.getID()!=0)
		{
			repo.delete(ID);
		}
	}
	
		
}
