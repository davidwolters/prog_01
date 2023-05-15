package com.chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.UUID;

import com.chat.main.Message;


public class ServerClient implements Runnable {
	
	public UUID uuid;
	public Socket socket;
	public ObjectOutputStream outputStream;
	public ObjectInputStream inputStream;
	public Server server;
	public String name;
	
	public ServerClient(Socket socket, Server server) throws IOException {
		uuid = UUID.randomUUID();
		this.socket = socket;
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		inputStream = new ObjectInputStream(socket.getInputStream());
		this.server = server;
	}

	@Override
	public void run() {
		while (server.isRunning()) {
			try {
				Message message = (Message) inputStream.readObject();
				server.messageRecieved(this, message);
			} catch (IOException e) {
				disconnect();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void disconnect() {
		try {
			socket.close();
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		server.clientDisconnected(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ServerClient) return ((ServerClient) obj).uuid == uuid;
		return false;
	}
}
