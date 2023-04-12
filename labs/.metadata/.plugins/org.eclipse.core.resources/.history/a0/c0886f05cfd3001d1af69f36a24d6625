package com.clock.util;

import java.awt.Dimension;

import com.clock.Config;

public class Vector {
	public double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int getScaledX() {
		return (int)(this.x * Config.WINDOW_SCALE);
	}
	
	public int getScaledY() {
		return (int)(this.y * Config.WINDOW_SCALE);
	}
	
	public Dimension getScaledDimension() {
		return new Dimension(getScaledX(), getScaledY());
	}
	
	public Vector getEndFromAngle(double angle, double length) {
		double xEnd = Math.cos(Math.toRadians(angle))*length;
		double yEnd = Math.sin(Math.toRadians(angle))*length;
		return new Vector(this.x + xEnd, this.y + yEnd);
	}
}
