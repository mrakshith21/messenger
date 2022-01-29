package javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import javabrains.messenger.model.Message;
import javabrains.messenger.model.Profile;
import lombok.Getter;

public class Database {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	
	
}
