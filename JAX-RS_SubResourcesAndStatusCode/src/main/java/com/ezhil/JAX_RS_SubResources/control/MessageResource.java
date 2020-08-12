package com.ezhil.JAX_RS_SubResources.control;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ezhil.JAX_RS_SubResources.control.bean.FilterBean;
import com.ezhil.JAX_RS_SubResources.model.Message;
import com.ezhil.JAX_RS_SubResources.service.MessageService;

@Path("/message")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessage(@BeanParam FilterBean filterBean){
		if(filterBean.getYear()>0) {
			return messageService.getMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart()>=0 && filterBean.getSize()>=0) {
			return messageService.getMessagePaginated(filterBean.getStart(), filterBean.getSize());
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
	public Response postMessage(Message message, @Context UriInfo uriInfo) {
		Message newMsg= messageService.addMessage(message);
		String newId = String.valueOf(newMsg.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMsg).build();
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
	
	@Path("{messageId}/comment")
	public CommentResource getComment() {
		return new CommentResource();
	}
	
	

}
