package javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javabrains.messenger.database.Database;
import javabrains.messenger.exceptions.DataNotFoundException;
import javabrains.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public MessageService() {
		 messages.put(1L, new Message(1, "Hello World", "Rakshith"));
		 messages.put(2L, new Message(2, "How are you doing?", "Sathvik"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageByYear(int year){
		List<Message> messagesByYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year){
				messagesByYear.add(message);
			}
		}
		return messagesByYear;
	}
	
	
	
	public List<Message> getAllMessagePaginated(int start, int size){
		
		List<Message> list = new ArrayList<>(messages.values());
		if(start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		
//		if(message == null) {
//			throw new DataNotFoundException("Message with id " + id + " not found");
//			
//		}
		System.out.print(message.getMessage());
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
