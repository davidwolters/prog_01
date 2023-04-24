package com.pool.components.table;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.pool.components.Component;
import com.pool.components.GameObject;
import com.pool.components.ball.BallSprite;
import com.pool.components.ball.QueueBallBehaviour;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Vector;

public class TableHoles extends Component {

	private final int NUM_HOLES = 6;
	private Vector[] holesPos = new Vector[NUM_HOLES];
	
	private ArrayList<GameObject> balls = new ArrayList<>();

	@Override
	public void init() {
		calcHolesPosition();
		
	}

	public void calcHolesPosition() {
		Vector tablePos = gameObject.position;
		int inset = Config.Table.HOLE_INSET;
		Vector size = Config.Table.SIZE;
		int w = size.x();
		int h = size.y();
		Vector t = Vector.offsetCenter(Config.Table.SIZE);
		int d = Config.Table.HOLE_D;
		holesPos[0] = t.add(new Vector(inset, inset));
		holesPos[1] = t.add(new Vector(w/2, inset));
		holesPos[2] = t.add(new Vector(w - inset, inset));
		holesPos[3] = t.add(new Vector(inset, h - inset));
		holesPos[4] = t.add(new Vector(w/2, h - inset));
		holesPos[5] = t.add(new Vector(w - inset, h - inset));
	}

	@Override
	public void update() {
		balls = gameObject.scene.findManyByTag(GameObjectTag.BALL);
		checkCollissions();
	}
	
	private void checkCollissions() {
		for (GameObject ball : balls) 
			for (Vector hole : holesPos) 
				checkBallHole(ball, hole);
	}
	
	private void checkBallHole(GameObject ball, Vector hole) {
		if (hole.distance(ball.position) < (Config.Table.HOLE_D / 2) + (Config.Ball.SIZE / 2)) {
			onCollisionWithBall(ball);
		}
	}
	
	private void onCollisionWithBall(GameObject ball) {
		BallSprite ballSprite = (BallSprite) ball.getComponent(BallSprite.class);
		if (ballSprite.isQueueBall()) {
			QueueBallBehaviour qb = (QueueBallBehaviour) ball.getComponent(QueueBallBehaviour.class);
			qb.setIsOffSide(true);
		} else {
			ball.destroy();
		}
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(Config.Table.HOLE_COLOR);
		for (Vector hp : holesPos) {
			int r = Config.Table.HOLE_D / 2;
			g.fillOval(hp.x() - r, hp.y() - r, Config.Table.HOLE_D, Config.Table.HOLE_D);
		}
	}
}
