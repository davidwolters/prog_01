package com.pool.components.ball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.text.Position;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class BallSprite extends Component {
	
	
	private boolean isStriped;
	public boolean isColliding;
	private int number;
	
	private Color color;
	private BallWellnessBehaviour wellnessBehaviour;
	
	
	public BallSprite(int number) {
		this.number = number;
	}
	
	
	@Override
	public void init() {
		wellnessBehaviour = (BallWellnessBehaviour) gameObject.getComponent(BallWellnessBehaviour.class);
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
		
		g.setColor(wellnessBehaviour.isSick() ? Config.Ball.SICK_COLOR : Config.Ball.WELL_COLOR);
		g.fillOval(x, y, (int)r*2, (int)r*2);
	}
	

}
