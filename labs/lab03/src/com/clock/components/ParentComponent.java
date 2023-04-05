package com.clock.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public abstract class ParentComponent extends JPanel {
	
	protected ArrayList<Component> components = new ArrayList<>();


	public void addComponent(Component c) {
		components.add(c);
	}
	
	protected abstract void beforePaint(Graphics2D g);
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(getGraphics());
		beforePaint((Graphics2D) g);
		for (Component c: components) {
			c.update();
			c.paint((Graphics2D) g);
		}
	}
}
