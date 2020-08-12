package com.ezhil.JAX_RS_SubResources.control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	
	@GET
	public String test() {
		return "Test msg";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") long commentId,@PathParam("messageId") long messageId ) {
		return "MessageId  : "+messageId+" ; Comment Id : "+commentId;
	}

}
