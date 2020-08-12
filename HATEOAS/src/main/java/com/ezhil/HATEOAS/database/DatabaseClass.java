package com.ezhil.HATEOAS.database;

import java.util.HashMap;
import java.util.Map;

import com.ezhil.HATEOAS.model.Message;
import com.ezhil.HATEOAS.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessage(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}

}
