package com.clock.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.clock.Config;
import com.clock.components.ClockFrame;

public class App implements ActionListener {
	
	
	public static void main(String[] args) {
		new App();
		
	}
	
	public App() {
		
		new ClockFrame("hi");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("hi");
		
	}
}
