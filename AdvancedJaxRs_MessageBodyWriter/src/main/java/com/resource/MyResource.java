package com.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class MyResource {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date test1() {
		
		return Calendar.getInstance().getTime(); 
	}
	
	@GET
	@Produces("text/shortDate")
	public Date test2() {
		
		return Calendar.getInstance().getTime(); 
	}

}
