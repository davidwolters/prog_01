package com.pool.components;

import com.pool.components.ball.BallSprite;
import com.pool.components.ball.BallWellnessBehaviour;
import com.pool.components.table.TableBorder;
import com.pool.components.table.TableHoles;
import com.pool.components.table.TableSprite;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Physics;
import com.pool.util.Vector;

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
			
			do {
				ball.position = new Vector(
					Math.random() * (Config.Table.SIZE.x - Config.Ball.SIZE) + Config.Ball.SIZE,
					Math.random() * (Config.Table.SIZE.y - Config.Ball.SIZE) + Config.Ball.SIZE
				).add(table.position);
			} while (!noCollisions(balls, ball));
				System.out.println(ball.position);
			balls[i] = ball;
		}
		return balls;
	}
	
	private static GameObject makeBall(int number, GameObject table) {
		GameObject ball = new GameObject(GameObjectTag.BALL, Vector.ZERO);
		ball.setParent(table);
		ball.addComponent(new BallSprite());
		ball.addComponent(new BallWellnessBehaviour(Math.random() < Config.Ball.INITIAL_SICK_CHANCE));
		RigidBody rb = new RigidBody();
		ball.addComponent(rb);
		int max = 80;
		rb.speed = new Vector(Math.random()*max*2 - max, Math.random()*max*2 - max);
		return ball;
	}
	
	public static GameObject makeBallPhysicsHandler() {
		GameObject g = new GameObject(GameObjectTag.BALL_PHYSICS, Vector.ZERO);
		g.addComponent(new BallPhysicsHandler());
		return g;
	}
	
	private static boolean noCollisions(GameObject[] balls, GameObject newBall) {
		
		for (GameObject ball : balls) {
			if (ball == null) break;
			if (Physics.ballsCollide(ball, newBall) && !ball.equals(newBall)) return false;
		}
		return true;
	}
}
