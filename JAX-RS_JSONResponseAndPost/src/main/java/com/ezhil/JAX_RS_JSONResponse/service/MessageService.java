package com.ezhil.JAX_RS_JSONResponse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ezhil.JAX_RS_JSONResponse.database.DatabaseClass;
import com.ezhil.JAX_RS_JSONResponse.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessage();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Ezhil"));
		messages.put(2L, new Message(2, "Hello India", "Ezhil"));
	}
	
	public List<Message> getAllMessage(){
		
		return new ArrayList<Message>(messages.values());	
		
	}
	
	public Message getMessages(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}
