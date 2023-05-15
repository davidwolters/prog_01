package com.chat.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.chat.gui.ChatGUI;
import com.chat.gui.ServerGUI;
import com.chat.main.Message;

public class Server {

	private ArrayList<ServerClient> clients = new ArrayList<ServerClient>();
	private ArrayList<Thread>  clientThreads = new ArrayList<Thread>();
	
	private boolean running = true;
	
	public int port;
	
	private ServerSocket socket;

	
	private ServerGUI gui;

	public Server() {
		port = Integer.parseInt(JOptionPane.showInputDialog("Enter port"));
		setupGUI();
		try {
			socket = new ServerSocket(port);
			gui.addString("Server started. Waiting for clients.");
			listenForClients(socket);
		} catch (IOException ex) {
			gui.addString("Error starting server");
		}
		
	}
	
	private void setupGUI() {
		gui = new ServerGUI(this);
		gui.addString("Started server on port " + port);
	}
	
	private void listenForClients(ServerSocket serverSocket) throws IOException {
		while (running) {
			ServerClient client = new ServerClient(serverSocket.accept(), this);
			startClientThread(client);
			clients.add(client);
			gui.addString("Client connected: " + client.uuid);
		}

	}
	
	public void startClientThread(ServerClient client) {
		Thread clientThread = new Thread(client);
		clientThread.start();
		clientThreads.add(clientThread);
	}
	
	public void messageRecieved(ServerClient client, Message message) {
		gui.addMessage(message);
		for (ServerClient c : clients) {
			if (c.equals(client)) continue;
			try {
				c.outputStream.writeObject(message);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		if (message.isJoinMessage()) {
			client.name = message.sender;
			sendWelcomeMessage(client);
		}
	}
	
	private void sendWelcomeMessage(ServerClient client) {
		try {
			client.outputStream.writeObject(getWelcomeMessage(client));
		} catch (IOException e) {}
	}
	
	private Message getWelcomeMessage(ServerClient client) {
		String[] participants = new String[clients.size()];
		
		if (clients.size() == 1) return new Message("Server", "Welcome! You are the first one here!");
		
		for (int i = 0; i < clients.size(); i++) {
			ServerClient c = clients.get(i);
			participants[i] = c.equals(client) ? "yourself" : c.name;
		}
		
		return new Message("Server", "Welcome! You are here with " + String.join(", ", participants));
	}
	
	public void closeServer() {
		running = false;
		System.out.println("Closing server");
	
		
		for (int i = 0; i < clients.size(); i++) {
			ServerClient c = clients.get(i);
			if (c == null) continue;
			try {
				c.outputStream.writeObject(Message.getExitMessage("Server"));
				c.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		try {
			socket.close();
		} catch (IOException e) {
			
				e.printStackTrace();
		}
		
	}
	
	public void clientDisconnected(ServerClient client) {
		clients.remove(client);
	}
	
	public int getNumClientsConnected() {
		return clients.size();
	}
	
	public boolean isRunning() {
		return running;
	}
}