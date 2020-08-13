package com.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		/*
		 * Response resp =
		 * client.target("http://localhost:8080/AdvancedJaxRs_Client/webapi/message/1").
		 * request().get(); Message message = resp.readEntity(Message.class);
		 * System.out.println(message.getAuthor());
		 */
		
		/*
		 * String message =
		 * client.target("http://localhost:8080/AdvancedJaxRs_Client/webapi/message/1")
		 * .request(MediaType.APPLICATION_JSON) .get(String.class);
		 * System.out.println(message);
		 */
		
		WebTarget baseTarget = client.target("http://localhost:8080/AdvancedJaxRs_Client/webapi/");
		WebTarget messageTarget = baseTarget.path("/message");
		WebTarget singleTarget = messageTarget.path("{messageId}");
		
		Message message = singleTarget.resolveTemplate("messageId", 1)
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		//System.out.println(message.getAuthor());
		
		//POST Operation
		
		Message newMessage = new Message(3, "Welcome to REST Client", "Sandhiya");
		Response response = messageTarget.request()
				.post(Entity.json(newMessage));
		if(response.getStatus()!=201) {
			System.out.println("Error");
		}
		Message createdMessage = response.readEntity(Message.class);
		
		System.out.println(createdMessage.getMessage());
				
		
		
		
		
	}

}
