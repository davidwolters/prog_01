package com.clock.components;

import java.awt.Graphics2D;
import java.awt.Polygon;

import com.clock.Config;
import com.clock.util.Calc;
import com.clock.util.TimeHandType;
import com.clock.util.Vector;

public class Bullet extends Component {
	
	private Vector pos;
	private double angle;

	private int[] xpoints = new int[Config.Bullet.VERTICES];
	private int[] ypoints = new int[Config.Bullet.VERTICES];
	
	public Bullet(Vector pos, double angle) {
		this.pos = pos;
		this.angle = angle;
	
	}

	@Override
	public void update() {
		pos = pos.getEndFromAngle(angle, Config.Bullet.SPEED);
		int[][] points = Calc.getRandomPolygon(
				pos,
				Config.Bullet.SIZE,
				Config.Bullet.RAND_RANGE,
				Config.Bullet.VERTICES
		);

		xpoints = points[0];
		ypoints = points[1];
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(Config.Bullet.COLOR);
		g.drawPolygon(xpoints, ypoints, Config.Bullet.VERTICES);
	}
	
	
	public boolean isOutOfBounds() {
		return this.pos.x > Config.WINDOW_W + Config.Bullet.SIZE
				|| this.pos.x < - Config.Bullet.SIZE
				|| this.pos.y > Config.WINDOW_H + Config.Bullet.SIZE
				|| this.pos.y < -Config.Bullet.SIZE;
	}

	
}
