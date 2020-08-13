package com.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		List<Message> msg =  client.target("http://localhost:8080/AdvancedJaxRs_Client/webapi/")
				.path("message")
				.queryParam("year", 2020)
				.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Message>>(){ });
		System.out.println(msg);

	}

}
