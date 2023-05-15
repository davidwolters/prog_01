package com.chat.gui;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.chat.client.Client;
import com.chat.main.Contact;
import com.chat.util.FileReader;

public class ClientInfoPrompt {
	

	private JComboBox<String> comboBox;
	
	public Contact contact;
	public String name;
	

	public Client client;
	
	public void getInfoAndCallback(Client client) {
		try {
			EventQueue.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					showDialog();
					if (contact != null) {
					}
				}
			});
			
			while (contact == null) {}
			
			client.connectClient();
		} catch (InvocationTargetException e) {
			client.die("Invocation exception: Please try again.");
		} catch (InterruptedException e) {
			client.die("Interrupted. Please try again.");
		}
	}
	
	public void showDialog() {
		// Show file picker
		JFileChooser fileChooser = new JFileChooser();
		System.out.println("here 1");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Contacts file (.txt)", "txt");
		System.out.println("here 2");
		fileChooser.setFileFilter(filter);
		System.out.println("here 3");
		fileChooser.showOpenDialog(null);
		System.out.println("here");
		File file = fileChooser.getSelectedFile().getAbsoluteFile();
		
		
		ArrayList<Contact> contacts = FileReader.getContactsFromFile(file);
		
		selectContact(contacts);
	}
	
	private void selectContact(ArrayList<Contact> contacts) {
		JPanel panel = new JPanel();
		String[] contactNames = getContactNames(contacts);
		comboBox = new JComboBox<String>(contactNames);
		panel.add(comboBox);
		
		String[] options = new String[] { "OK" };
		String title = "Select chatroom";
		
		int selection = JOptionPane.showOptionDialog(null, comboBox, title,
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
		        options[0]);
	
		String selectedName = (String) comboBox.getSelectedItem();
		contact = getSelectedContact(selectedName, contacts);
		
		if (contact == null) {
			client.die("Error selecting contact");
			return;
		}
		
		
		name = JOptionPane.showInputDialog("Enter nickname");
		
		if (name.isEmpty()) {
			client.die("Please select a name");
			return;
		}

	}
	
	private String[] getContactNames(ArrayList<Contact> contacts) {
		String[] names = new String[contacts.size()];
		for (int i = 0; i < contacts.size(); i++) {
			names[i] = contacts.get(i).name;
		}
		return names;
	}
	
	private Contact getSelectedContact(String name, ArrayList<Contact> contacts) {
		for (Contact c : contacts)
			if (c.name == name)
				return c;
		return null;
	}
}
