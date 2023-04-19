package com.clock.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import com.clock.util.Vector;

public class DiagonalLine extends Component {

	
	protected Vector start;
	protected Vector end;
	protected Color color;
	protected double angle;
	protected double length;
	protected float width = 1;
	
	public DiagonalLine(Vector start, double angle, double length, Color color, float width) {
		this.start = start;
		this.angle = angle;
		this.color = color;
		this.length = length;
		this.width = width;
	}
	
	public DiagonalLine() {
		
	}

	@Override
	public void update() {
		end = start.getEndFromAngle(angle, length);
	}

	@Override
	public void paint(Graphics2D g) {
		g.setStroke(new BasicStroke(width));
		g.setColor(color);
		g.draw(new Line2D.Float(start.getScaledX(), start.getScaledY(), end.getScaledX(), end.getScaledY()));
	}
}