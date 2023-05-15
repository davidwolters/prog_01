package com.chat.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.chat.client.Client;
import com.chat.gui.ChatGUI;
import com.chat.server.Server;

public class App {
    public static void main(String[] args) throws IOException {
        final int port = 2000;
        int startServerResult = JOptionPane.showConfirmDialog(null, "Do you want to start a server?", "Warning", JOptionPane.YES_NO_OPTION);
        boolean startServer = startServerResult == 0;
        
        try {
        	if (startServer)  {
        		Server server = new Server();
        	} else {
        		new Client();
        	}
        	
        } catch (IOException e) {
            System.out.println("Client failed, starting Server");
            Server server = new Server();
        }
    }
}
