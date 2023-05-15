package com.chat.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.chat.main.Message;
import com.chat.server.Server;

public class ServerGUI extends JFrame implements ActionListener {
	
	private Server server;
	
	private JButton closeButton;
	private JTextArea chatArea;
	
	private JLabel infoLabel = new JLabel("");
	private long secondsAlive = 0;
	
	private Timer timer;

	public ServerGUI(Server server) {
		this.server = server;
		
		setTitle("Chat Server: " + server.port);
		createChatArea();
		
		closeButton = new JButton("Close Server");
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				server.closeServer();
				dispose();
			}
		});
		
		add(closeButton, BorderLayout.SOUTH);
		add(infoLabel, BorderLayout.NORTH);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startTimer();
		
	}
	
	private void startTimer() {
		timer = new Timer(1000, this);
		timer.start();
	}
	
	private String now() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return (dtf.format(now));  
	}
	
	private void createChatArea() {
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(chatArea);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void addString(String s) {
		chatArea.append(now() + "[INFO] " + s + "\n");
	}
	
	public void addMessage(Message message) {
		chatArea.append(now() + message.toString() + "\n");
	}
	
	private void updateInfoLabel() {
		long s = secondsAlive;
		int h = 3600;
		int m = 60;
		int hours = Math.round(s/3600);
		int minutes = Math.round((s-(hours*3600))/60);
		int seconds = Math.round(s - (hours*3600) - (minutes*3600));
		String timeAlive = pad(hours) + ":" + pad(minutes) + ":" + pad(seconds);

		String clientsAlive = server.getNumClientsConnected() + " clients connected";
		
		infoLabel.setText(timeAlive + ", " + clientsAlive);
		
	}
	
	private String pad(int s) {
		if (s < 10) return "0" + s;
		return "" + s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		secondsAlive++;
		updateInfoLabel();
		if (!server.isRunning()) {
			timer.stop();
		}
	}
}
