package com.clock.components;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Component {
	public abstract void update();
	public abstract void paint(Graphics2D g);
}
