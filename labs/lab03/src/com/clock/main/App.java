package com.clock.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.clock.Config;
import com.clock.components.ClockFrame;

public class App {
	
	
	public static void main(String[] args) {
		new App();
	}
	
	public App() {
		ClockFrame myClock = new ClockFrame("Clock");
	}


}
