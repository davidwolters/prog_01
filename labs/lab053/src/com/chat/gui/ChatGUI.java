package com.chat.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.chat.client.Client;
import com.chat.main.Message;
import com.chat.server.ServerClient;

public class ChatGUI extends JFrame {


    private JTextArea chatArea;
    private JTextField inputField;
    private JPanel inputPanel;
    

    private boolean running = true;
    
    private Client client;

    public ChatGUI(Client client) throws IOException {
    	this.client = client;
    }
    
    public void onReady(String chatRoomName) {
    	setTitle("Connected: " + chatRoomName);
    }
    
    public void setupGUI() {
    	setTitle("Connecting...");
        createChatArea();
        createInputPanel();
        JButton closeButton = new JButton("Leave");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = false;
                closeChat();
                client.closeChat();
            }
        });

		inputPanel.add(closeButton);
 
        setSize(500, 300);
        setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

 

    private void createChatArea() {
        chatArea = new JTextArea(10, 40);
        chatArea.setEditable(false);
        chatArea.setBackground(Color.orange);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void createInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBackground(Color.black);
        inputField = new JTextField();


        inputField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!inputField.getText().isEmpty()) {
                        String message = inputField.getText();
                        appendToChatArea(new Message("You", message).toString());
                        sendMessage(message);
                        inputField.setText("");
                    }
                }
            }
        });
        inputPanel.add(inputField);
        add(inputPanel, BorderLayout.SOUTH);
    }

    public void appendToChatArea(String message) {
        chatArea.append(message + "\n");
    }

    private void sendMessage(String message) {
    	 try {
    		 client.sendMessage(message);
         } catch (IOException ex) {
             System.out.println("Error sending message");
         }	
    }
    
    public void closeChat() {
    	closeChat(true);
    }
    
    public void closeChat(boolean fromServer) {
    	if (fromServer) JOptionPane.showMessageDialog(this, "The chat has been closed");
    	
        dispose();
    }
}

