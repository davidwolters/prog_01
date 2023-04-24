package com.pool.components;

import com.pool.components.ball.*;
import com.pool.components.gameover.PlayAgainButton;
import com.pool.components.gameover.WinnerSprite;
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
			GameObject ball = makeBall(i, table);
			
			// Try to find a position that has no collisions between the other balls.
			do {
				ball.position = new Vector(
						randomPos(Config.Table.SIZE.x),
						randomPos(Config.Table.SIZE.y)
				).add(table.position);
			} while (!noCollisions(balls, ball));
			balls[i] = ball;
		}
		return balls;
	}
	
	public static GameObject makeWinCondition() {
		GameObject go = new GameObject(GameObjectTag.WIN_CONDITION, Vector.ZERO);
		go.addComponent(new WinCondition());
		return go;
	}
	
	public static GameObject makeBG() {
		GameObject go = new GameObject(GameObjectTag.BG, Vector.ZERO);
		go.addComponent(new Background());
		return go;
	}
	
	public static GameObject makeWinSprite(boolean stripedWins) {
		GameObject go = new GameObject(GameObjectTag.WIN_SPRITE, Vector.ZERO);
		go.addComponent(new WinnerSprite(stripedWins));
		return go;
	}
	
	public static GameObject makePlayAgainButton() {
		GameObject go = new GameObject(GameObjectTag.PLAY_AGAIN, Vector.ZERO);
		go.addComponent(new PlayAgainButton());
		return go;
	}
	
	private static double randomPos(double maxSize) {
		double padding = Config.Ball.SIZE + Config.Table.BORDER_WIDTH + Config.Table.PADDING;
		return Math.random() * (maxSize - padding*2) + padding;
	}
	
	private static GameObject makeBall(int number, GameObject table) {
		GameObject ball = new GameObject(GameObjectTag.BALL, Vector.ZERO);
		ball.addComponent(new BallSprite(number));
		if (number == 0) {
			ball.addComponent(new BallAimBehaviour());
			ball.addComponent(new QueueBallBehaviour());
		}

		ball.addComponent(new RigidBody());
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
