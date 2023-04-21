package com.pool.components.ball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.text.Position;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class BallSprite extends Component {
	
	
	boolean isStriped;
	int number;
	
	Color color;
	
	
	public BallSprite(int number) {
		this.number = number;
		isStriped = number > Config.Ball.NUM_BALLS / 2;
		color = getColorFromNumber();
	}

	@Override
	public void update() {
	}

	@Override
	public void paint(Graphics2D g) {
		Vector pos = gameObject.position;
		double r = Config.Ball.SIZE / 2;
		int x = (int)(pos.x() - r);
		int y = (int)(pos.y() - r);
		
		g.setColor(color);
		g.fillOval(x, y, (int)r*2, (int)r*2);
		if (isStriped) {
			int stripeR = Config.Ball.STRIPE_SIZE / 2;
			int cx = (int) (x + r);
			int cy = (int) (y + r);
			int sx = (int) (x + r - stripeR);
			int sy = (int) (y + r - stripeR);
			g.setColor(Config.Ball.STRIPE);
			g.fillOval(sx, sy, stripeR*2, stripeR*2);
		}

		
		int w = Config.Ball.OUTLINE_W;
		g.setStroke(new BasicStroke(w));
		g.setColor(Config.Ball.OUTLINE);
		g.drawOval(x - ((int) w/2), y - ((int) w/2), (int)r*2, (int)r*2);
		
	}
	
	
	private Color getColorFromNumber() {
		switch (number) {
		case 1, 9:
			return Config.Ball.COLOR_1; 
		case 2, 10:
			return Config.Ball.COLOR_2; 
		case 3, 11:
			return Config.Ball.COLOR_3; 
		case 4, 12:
			return Config.Ball.COLOR_4; 
		case 5, 13:
			return Config.Ball.COLOR_5; 
		case 6, 14:
			return Config.Ball.COLOR_6; 
		case 7, 15:
			return Config.Ball.COLOR_7; 
		case 8:
			return Config.Ball.COLOR_8;
		default:
			return Config.Ball.WHITE;
		}
	}

}
