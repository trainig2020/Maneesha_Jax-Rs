package com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
public class DateResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDate(@PathParam("dateString") MyDate myDate) {
		return "My Requested Date is : "+myDate.toString();
		
	}

}
