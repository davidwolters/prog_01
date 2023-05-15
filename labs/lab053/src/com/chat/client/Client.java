package com.chat.client;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.chat.gui.ChatGUI;
import com.chat.gui.ClientInfoPrompt;
import com.chat.main.Message;

public class Client {
	boolean isServer = false;

	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private String name;
	private boolean running = true;
	private ChatGUI gui;
	
	private ClientInfoPrompt infoPrompt;

	public Client() throws IOException {
		System.out.println("Starting client");
		gui = new ChatGUI(this);
		gui.setupGUI();
		infoPrompt = new ClientInfoPrompt();
		infoPrompt.getInfoAndCallback(this);
	}
	
	public void connectClient() {
		try {
			socket = new Socket(infoPrompt.contact.ip, infoPrompt.contact.port);
			name = infoPrompt.name;
			startClient();
			gui.onReady(infoPrompt.contact.name);
			sendJoinMessage();
			listenForMessages();
		} catch (IOException e) {
			die();
			e.printStackTrace();
		}
	}

	public void startClient() {
		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
			System.out.println("here");
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	private void sendJoinMessage() {
		try {
			sendMessage(Message.getJoinMessage(name));
			System.out.println("sendJoinMessage()");
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "Error joining chat", "Error", JOptionPane.OK_OPTION);
		}
	}

	private void listenForMessages() {
		while (running) {
			try {
				System.out.println("Listening");
				Message message = (Message) inputStream.readObject();
				System.out.println(message.toString());
				gui.appendToChatArea(message.toString());
				if (message.isExitMessage() && message.sender == "Server") {
					closeChat();
					gui.closeChat();
				}
			} catch (ClassNotFoundException ex) {
				die();
			} catch (IOException e) {
				die();
			}
		}
	}
	
	public void die() {
		die("Connection error");
	}
	
	public void die(String error) {
		
		String[] options = { "Ok" };
		JOptionPane.showOptionDialog(null, error, "Error", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
		closeChat();
		gui.closeChat(false);
	}

	public void sendMessage(Message message) throws IOException {
		outputStream.writeObject(message);
	}

	public void sendMessage(String message) throws IOException {
		sendMessage(new Message(name, message));
	}
	
	private void sendExitMessage() {
		try {
			sendMessage(Message.getExitMessage(name));
		} catch (IOException ex) { }
	}
	
	public void closeChat() {
		if (socket == null) return;
		try {
			sendExitMessage();
			running = false;
			socket.close();
			inputStream.close();
			outputStream.close();

		} catch (IOException e) {
		}
	}

}
