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
	
	public Dimension getDimension() {
		return new Dimension((int) x, (int) y);
	}
	
	public int x() {
		return (int) x;
	}
	
	public int y() {
		return (int) y;
	}

	
	public Vector getEndFromAngle(double angle, double length) {
		double xEnd = Math.cos(Math.toRadians(angle))*length;
		double yEnd = Math.sin(Math.toRadians(angle))*length;
		return new Vector(this.x + xEnd, this.y + yEnd);
	}
	
	public static Vector norm(Vector v) {
		return new Vector(v.x / length(v), v.y / length(v));
	}
	
	public Vector norm() {
		return norm(this);
	}
	
	public Vector scale(double scale) {
		return scale(this, scale);
	}
	
	public static Vector scale(Vector v, double scale) {
		return new Vector(v.x * scale, v.y * scale);
	}
	
	public static double scalar(Vector a, Vector b) {
		return a.x*b.x + a.y*b.y;
	}
	
	public double scalar(Vector b) {
		return scalar(this, b);
	}
	
	public Vector add(Vector b) {
		return add(this, b);
	}
	
	public static Vector add(Vector a, Vector b) {
		return new Vector(a.x + b.x, a.y + b.y);
	}
	
	public Vector sub(Vector b) {
		return sub(this, b);
	}
	
	public static Vector sub(Vector a, Vector b) {
		return add(a, scale(b, -1));
	}
	
	public double length() {
		return length(this);
	}

	public static double length(Vector v) {
		return Math.sqrt(v.x*v.x + v.y*v.y);
	}
	
	public double distance(Vector b) {
		return distance(this, b);
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
