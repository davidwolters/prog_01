package com.chat.main;

import java.io.Serializable;


public class Message implements Serializable {

	public String sender;
	public String message;
	private MessageType messageType = MessageType.MESSAGE;
	

	public Message(String sender, String message) {
		this.sender = sender;
		this.message = message;
	}
	
	public Message() {
		
	}
	
	public static Message getExitMessage(String sender) {
		Message message = new Message(sender, "");
		message.messageType = MessageType.EXIT;
		return message;
	}
	
	public static Message getJoinMessage(String sender) {
		Message message = new Message(sender, "");
		message.messageType = MessageType.JOIN;
		return message;
	}
	
	public boolean isExitMessage() {
		return messageType == MessageType.EXIT;
	}
	
	public boolean isJoinMessage() {
		return messageType == MessageType.JOIN;
	}
	
	
	@Override
	public String toString() {
		switch (messageType) {
		case JOIN:
			return sender + " has joined the chat";
		case EXIT:
			return sender + " has left the chat";
		default:
			return sender + ": " + message;
		}
	}
}
