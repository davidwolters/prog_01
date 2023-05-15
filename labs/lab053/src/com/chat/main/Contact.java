package com.chat.main;


public class Contact {

	public String name;
	public String ip;
	public int port;

	public Contact(String name, String ip, int port) {
		this.name = name;
		this.ip = ip;
		this.port = port;
	}
	
	public static Contact fromString(String string) {
		String[] parts = string.split(",");
		return new Contact(parts[0], parts[1], Integer.parseInt(parts[2]));
	}
	
	@Override
	public String toString() {
		return ip + ":" + port + " (" + name + ")";
	}
}
