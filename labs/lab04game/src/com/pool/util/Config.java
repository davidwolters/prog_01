package com.pool.util;

import java.awt.Color;
import java.awt.Font;

public class Config {

	public static final int FPS = 100;
	public static final int MILLIS_PER_SEC = 1000;
	
	public static final class Window {
		public static final int W = 1000;
		public static final int H = 600;
		public static final int SCALE = 1;
		public static final Color BG = new Color(150, 75, 0);
	}
	
	public static final class Table {
		public static final int W = 700;
		public static final int H = 500;
		public static final Vector SIZE = new Vector(W, H);
		public static final Color COLOR = new Color(0, 180, 20);
		public static final int HOLE_INSET = 5;
		public static final int HOLE_D = 40;
		public static final Color HOLE_COLOR = Color.BLACK;
		public static final Color BORDER_COLOR = new Color(75, 37, 0);
		public static final int PADDING = Config.Ball.SIZE * 1;
		public static final int BORDER_WIDTH = 20;
	}
	
	public static final class Ball {
		public static final Vector OFFSIDE_POS = new Vector(Window.W/2 + Table.W / 2, Window.H/2);
		public static final Color COLOR_0 = Color.WHITE;
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
		public static final int QUEUE_BALL_NUMBER = 0;
		public static final int NUM_BALLS = 16;
		public static final int SIZE = 30;
		public static final int STRIPE_SIZE = 20;
		public static final int OUTLINE_W = 2;
		public static final int TABLE_FRICTION = 80;
		public static final double SPEED_THRESHOLD = 100;
		public static final double WEIGHT = 10;
		public static final double AIM_MULTIPLIER = 2;
		public static final Color AIM_COLOR = Color.BLACK;
	}
	
	public static final class GameOver {
		public static String FONT_FAMILY = "Impact";
		public static int FONT_STYLE = Font.BOLD;
		public static int FONT_SIZE = 40;
		public static final Font FONT = new Font(FONT_FAMILY, FONT_STYLE, FONT_SIZE);
		public static final String STRIPED_WINS = "STRIPED wins!";
		public static final String SOLID_WINS = "SOLID wins!";
		public static final String PLAY_AGAIN = "Play Again!";
		public static final Color PLAY_AGAIN_COLOR = new Color(255, 50, 255);
		public static final int BUTTON_GAP = 150;
	}
}
