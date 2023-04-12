package com.clock;

import java.awt.Color;

import javax.crypto.spec.DHPublicKeySpec;

public class Config {
	public static final int WINDOW_W = 1000;
	public static final int WINDOW_H = 1000;
	public static final double WINDOW_SCALE = 1;
	public static final int MILLIS_PER_SEC = 1000;
	public static final int FPS = 10; 

	public static final int CLOCK_RADIUS = 500;
	
	public static final Color BG = Color.WHITE;

	
	public static final class Markers {
		public static final int H_LENGTH = 30;
		public static final int M_LENGTH = 15;
		public static final int S_LENGTH = 5;
		public static final int H_WIDTH = 3;
		public static final int M_WIDTH = 2;
		public static final int S_WIDTH = 1;
		public static final Color H_COLOR = new Color(100, 100, 100);
		public static final Color M_COLOR = new Color(200, 200, 200);
		public static final Color S_COLOR = new Color(220, 220, 220);
	}
	
	
	public static final class Hands {
		public static final int H_LENGTH = 200;
		public static final int M_LENGTH = 280;
		public static final int S_LENGTH = 400;
		public static final int H_WIDTH = 10;
		public static final int M_WIDTH = 7;
		public static final int S_WIDTH = 4;
		public static final int H_CIRCLE_SIZE = 50;
		public static final int M_CIRCLE_SIZE = 30;
		public static final int S_CIRCLE_SIZE = 20;
		public static final Color H_COLOR = new Color(100, 100, 100);
		public static final Color M_COLOR = new Color(100, 100, 100);
		public static final Color S_COLOR = new Color(100, 100, 100);
	}
	
	public static final class Face {
		public static final Color COLOR = new Color(70, 70, 70);
		public static final int WIDTH = 6;
		public static final int CENTER_WIDTH = 30;
	}
	
	public static final class Date {
		public static final Color COLOR = new Color(0, 0, 0);
		public static final Color TEXT = new Color(200, 200, 200);
		public static final int SIZE = 100;
		public static final int Y_OFFSET = 300;
		public static final String FONT = "Impact";
		public static final int FONT_SIZE = 20;
		public static final int GAP = 10;
	}
	
	public static final class Bullet {
		public static final int SPEED = 10;
		public static final int SIZE = 20;
		public static final int RAND_RANGE = 10;
		public static final int VERTICES = 6;
		public static final Color COLOR = new Color(100, 100, 100);
	}

}

/**
g.setColor
g.drawPolygon
g.setStroke
g.drawOval
g.fillRect
g.drawString
g.draw
g.fillOval
 */