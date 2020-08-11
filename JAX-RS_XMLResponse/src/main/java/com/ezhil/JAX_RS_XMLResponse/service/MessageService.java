package com.ezhil.JAX_RS_XMLResponse.service;

import java.util.ArrayList;
import java.util.List;

import com.ezhil.JAX_RS_XMLResponse.model.Message;

public class MessageService {
	
	public List<Message> getAllMessage(){
		Message m1 = new Message(1L, "Hello World", "Ezhil");
		Message m2 = new Message(2L, "Hello India", "Ezhil");
		List<Message> lst = new ArrayList<Message>();
		lst.add(m1);
		lst.add(m2);
		return lst;
	}

}
