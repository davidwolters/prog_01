package com.pool.util;

import java.awt.Color;

public class Config {

	public static final int FPS = 100;
	public static final int MILLIS_PER_SEC = 1000;
	
	public static final class Window {
		public static final int W = 1000;
		public static final int H = 600;
		public static final int SCALE = 1;
	}
	
	public static final class Table {
		public static final int W = 700;
		public static final int H = 500;
		public static final Vector SIZE = new Vector(W, H);
		public static final Color COLOR = new Color(0, 180, 20);
		public static final int HOLE_INSET = -10;
		public static final int HOLE_D = 30;
		public static final Color HOLE_COLOR = Color.BLACK;
		public static final Color BORDER_COLOR = new Color(100, 0, 50);
		public static final int BORDER_WIDTH = 20;
	}
	
	public static final class Ball {
		public static final Color SICK_COLOR = new Color(255, 0, 0);
		public static final Color WELL_COLOR = new Color(255, 255, 255);
		public static final double INFECT_CHANCE = 0.2;
		public static final double DIE_CHANCE = 0.02;
		public static final double RECOVER_CHANCE = 0.05;
		public static final double INITIAL_SICK_CHANCE = 0.2;
		public static final int NUM_BALLS = 10;
		public static final int SIZE = 30;
		public static final int STRIPE_SIZE = 10;
		public static final int OUTLINE_W = 2;
		public static final int TABLE_FRICTION = 0;
		public static final double SPEED_THRESHOLD = 20;
		public static final double WEIGHT = 10;
	}
}
