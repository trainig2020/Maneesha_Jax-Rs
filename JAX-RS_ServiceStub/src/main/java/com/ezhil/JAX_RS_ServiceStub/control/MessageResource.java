package com.ezhil.JAX_RS_ServiceStub.control;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ezhil.JAX_RS_ServiceStub.model.Message;
import com.ezhil.JAX_RS_ServiceStub.service.MessageService;

@Path("/message")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessage(){
		return messageService.getAllMessage();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessages(messageId);
	}

}
