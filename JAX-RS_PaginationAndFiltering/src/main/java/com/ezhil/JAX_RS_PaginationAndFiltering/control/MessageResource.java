package com.ezhil.JAX_RS_PaginationAndFiltering.control;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ezhil.JAX_RS_PaginationAndFiltering.model.Message;
import com.ezhil.JAX_RS_PaginationAndFiltering.service.MessageService;

@Path("/message")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessage(@QueryParam("year") int year,
										@QueryParam("start") int start,
										@QueryParam("size") int size){
		if(year>0) {
			return messageService.getMessagesForYear(year);
		}
		if(start>=0 && size>=0) {
			return messageService.getMessagePaginated(start, size);
		}
		return messageService.getAllMessage();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessages(messageId);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message postMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message putMessage(@PathParam("messageId") long messageId,Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long messageId) {
		 messageService.removeMessage(messageId);
	}
	
	

}
