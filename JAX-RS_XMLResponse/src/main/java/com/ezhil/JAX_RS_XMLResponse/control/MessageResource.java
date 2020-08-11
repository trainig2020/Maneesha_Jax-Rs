package com.ezhil.JAX_RS_XMLResponse.control;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ezhil.JAX_RS_XMLResponse.model.Message;
import com.ezhil.JAX_RS_XMLResponse.service.MessageService;

@Path("/message")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage(){
		return messageService.getAllMessage();
	}

}
