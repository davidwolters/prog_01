package com.pool.util;

import java.awt.Dimension;

import com.pool.ui.ScenePanel;


public class Vector {
	
	
	public static final Vector ZERO = new Vector(0, 0);
	
	public double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int getScaledX() {
		return (int)(this.x * Config.Window.SCALE);
	}
	
	public int getScaledY() {
		return (int)(this.y * Config.Window.SCALE);
	}
	
	public Dimension getScaledDimension() {
		return new Dimension(getScaledX(), getScaledY());
	}
	
	public Vector getEndFromAngle(double angle, double length) {
		double xEnd = Math.cos(Math.toRadians(angle))*length;
		double yEnd = Math.sin(Math.toRadians(angle))*length;
		return new Vector(this.x + xEnd, this.y + yEnd);
	}
	
	public static Vector scale(Vector v, double scale) {
		return new Vector(v.x * scale, v.y * scale);
	}
	
	public static Vector add(Vector a, Vector b) {
		return new Vector(a.x + b.x, a.y + b.y);
	}
	
	public static Vector sub(Vector a, Vector b) {
		return add(a, scale(b, -1));
	}
	
	public static int scaled(int d) {
		return d * Config.Window.SCALE;
	}
	
	public static double distance(Vector a, Vector b) {
		return Math.sqrt(
			Math.pow(a.x - b.x, 2) +
			Math.pow(a.y - b.y, 2)
		);
	}
	
	public static Vector offsetCenter(Vector dim) {
		return sub(ScenePanel.CENTER, scale(dim, .5));
	}
	
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
