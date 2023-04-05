package com.clock.components;

import java.awt.*;
import javax.swing.*;;

public class ClockFrame {
	
	private JFrame window;
	private ClockPanel panel;
	
	public ClockFrame(String name) {
		window = new JFrame(name);
		panel = new ClockPanel();
		panel.setPreferredSize(new Dimension(1000, 1000));

		initWindow();
	}
	
	
	private void initWindow() {
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.pack();
		window.setVisible(true);
	}
	
}
