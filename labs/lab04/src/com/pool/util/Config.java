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
		public static final Color COLOR_1 = new Color(255, 255, 0);
		public static final Color COLOR_2 = new Color(0, 0, 255);
		public static final Color COLOR_3 = new Color(255, 0, 0);
		public static final Color COLOR_4 = new Color(255, 0, 255);
		public static final Color COLOR_5 = new Color(255, 125, 125);
		public static final Color COLOR_6 = new Color(0, 255, 0);
		public static final Color COLOR_7 = new Color(255, 0, 100);
		public static final Color COLOR_8 = Color.BLACK;
		public static final Color STRIPE = Color.WHITE;
		public static final Color WHITE = Color.WHITE;
		public static final Color OUTLINE = Color.BLACK;
		public static final int NUM_BALLS = 15;
		public static final int SIZE = 20;
		public static final int STRIPE_SIZE = 10;
		public static final int OUTLINE_W = 2;
	}
}
