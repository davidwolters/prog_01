package com.clock.components;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

import com.clock.Config;;

public class ClockFrame extends JFrame {
	
	private ClockPanel panel;
	
	public ClockFrame(String name) {
		super(name);
		panel = new ClockPanel();
	}
	
	public void start() {
		panel.setFocusable(true);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
            }
        });
		
        setUndecorated(true);
		initWindow();
	}
	
	
	private void initWindow() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}

