package com.pool.components;

import com.pool.components.ball.*;
import com.pool.components.table.TableBorder;
import com.pool.components.table.TableHoles;
import com.pool.components.table.TableSprite;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Physics;
import com.pool.util.Vector;

/**
 * Factory class for composing together gameobjects.
 * @author david
 *
 */

public class GameObjectFactory {

	public static GameObject makeTable() {
		GameObject table = new GameObject(GameObjectTag.TABLE, Vector.offsetCenter(Config.Table.SIZE));
		table.addComponent(new TableSprite());
		table.addComponent(new TableHoles());
		table.addComponent(new TableBorder());
		return table;
	}
	
	public static GameObject[] makeBalls(GameObject table, int nBalls) {
		
		GameObject[] balls = new GameObject[nBalls];
		for (int i = 0; i < nBalls; i++) {
			GameObject ball = makeBall(i+1, table);
			
			// Try to find a position that has no collisions between the other balls.
			do {
				ball.position = new Vector(
					Math.random() * (Config.Table.SIZE.x/2 - Config.Ball.SIZE) + Config.Ball.SIZE,
					Math.random() * (Config.Table.SIZE.y - Config.Ball.SIZE) + Config.Ball.SIZE
				).add(table.position);
			} while (!noCollisions(balls, ball));
			balls[i] = ball;
		}
		return balls;
	}
	
	private static GameObject makeBall(int number, GameObject table) {
		GameObject ball = new GameObject(GameObjectTag.BALL, Vector.ZERO);
		ball.addComponent(new BallSprite(number));
		ball.addComponent(new BallWellnessBehaviour(Math.random() > Config.Ball.INITIAL_SICK_CHANCE));
		RigidBody rb = new RigidBody();
		
		double mag = Math.random() * (Config.Ball.MAX_SPEED - Config.Ball.MIN_SPEED) + Config.Ball.MAX_SPEED;
		double ang = Math.random() * Math.PI * 2;
		Vector speed = new Vector(Math.cos(ang), Math.sin(ang)).norm().scale(mag);
		rb.speed = speed;
		ball.addComponent(rb);
		return ball;
	}
	
	public static GameObject makeBallPhysicsHandler() {
		GameObject g = new GameObject(GameObjectTag.BALL_PHYSICS, Vector.ZERO);
		g.addComponent(new BallPhysicsHandler());
		return g;
	}
	
	// Check that there are no colissions between any of the balls and the new ball
	private static boolean noCollisions(GameObject[] balls, GameObject newBall) {
		for (GameObject ball : balls) {
			if (ball == null) break;
			if (Physics.ballsCollide(ball, newBall) && !ball.equals(newBall)) return false;
		}
		return true;
	}
}
