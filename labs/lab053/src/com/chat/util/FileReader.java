package com.chat.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.chat.main.Contact;

public class FileReader {

	
	public static ArrayList<String> readFile(File file) {
		ArrayList<String> lines = new ArrayList<>();
		try {
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				lines.add(line);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
		return lines;
	}
	
	public static ArrayList<Contact> getContactsFromFile(File file) {
		ArrayList<String> lines = readFile(file);
		ArrayList<Contact> contacts = new ArrayList<>();
		
		for (String line : lines) {
			if (line.isEmpty()) continue;
			contacts.add(Contact.fromString(line));
		}
		
		return contacts;
	}
}
