package com.pool.components.ball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.text.Position;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class BallSprite extends Component {
	
	
	
	Color color;
	
	boolean isSick;
	
	
	public BallSprite() {
	}

	@Override
	public void update() {
		isSick = ((BallWellnessBehaviour) gameObject.getComponent(BallWellnessBehaviour.class)).isSick();
		color = isSick ? Config.Ball.SICK_COLOR : Config.Ball.WELL_COLOR;
	}

	@Override
	public void paint(Graphics2D g) {
		Vector pos = gameObject.position;
		double r = Config.Ball.SIZE / 2;
		int x = (int)(pos.x() - r);
		int y = (int)(pos.y() - r);
		
		g.setColor(color);
		g.fillOval(x, y, (int)r*2, (int)r*2);
	}
}
