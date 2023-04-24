package com.pool.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.pool.components.table.TableBorder;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Message;
import com.pool.util.Physics;
import com.pool.components.ball.*;
import com.pool.util.Vector;

/**
 * Handles physics between balls and walls. Checks for collissions and uses
 * Physcis to update speeds.
 *
 */
public class BallPhysicsHandler extends Component {

	/**
	 * All balls on the table currently
	 */
	private ArrayList<GameObject> balls = new ArrayList();

	/**
	 * Positions for walls.
	 */
	private double leftWallX, rightWallX, topWallY, bottomWallY;

	@Override
	public void init() {
		super.init();

		// Find all balls on table.
		balls = gameObject.scene.findManyByTag(GameObjectTag.BALL);

		// Get the TableBorder component, and use it to find wall positions.
		TableBorder border = (TableBorder) gameObject.scene.findByTag(GameObjectTag.TABLE)
				.getComponent(TableBorder.class);
		leftWallX = border.getLeftWallX();
		rightWallX = border.getRightWallX();
		topWallY = border.getTopWallY();
		bottomWallY = border.getBottomWallY();
	}

	@Override
	public void update() {
		// If balls have been removed, we need to update the list.
		balls = gameObject.scene.findManyByTag(GameObjectTag.BALL);

		// Check collissions.
		checkBallToBallCollissions();
		checkBallToWallCollissions();
	}

	private void checkBallToBallCollissions() {

		// We store all collisions in a list, to avoid checking the same collision twice. Each arraylist entry is an array of two balls that have collided.
		ArrayList<GameObject[]> collissions = new ArrayList();

		for (GameObject ball : balls) {
			for (GameObject other : balls) {

				BallSprite b1 = (BallSprite) ball.getComponent(BallSprite.class);
				BallSprite b2 = (BallSprite) other.getComponent(BallSprite.class);

				if (!Physics.ballsCollide(ball, other)) {
					b1.isColliding = false;
					b2.isColliding = false;
				}
				if (ball.equals(other))
					continue;
				if (hasCollided(ball, other, collissions))
					continue;
				if (Physics.ballsCollide(ball, other)) {
					collissions.add(new GameObject[] { ball, other });
				}
			}
		}
		
		// When we know all collisions on the table, we can handle them at the "same" time.
		handleCollissions(collissions);
	}

	private void checkBallToWallCollissions() {
		for (GameObject ball : balls) {
			// Retrieve the rigidbody component of the ball, and if there is a wall collision, reverse the appropriate speed axis.
			RigidBody rb = (RigidBody) ball.getComponent(RigidBody.class);
			if (Physics.leftWallCollission(ball.position.x, leftWallX, rb.speed.x))
				rb.speed.x = -rb.speed.x;
			else if (Physics.rightWallCollission(ball.position.x, rightWallX, rb.speed.x))
				rb.speed.x = -rb.speed.x;
			else if (Physics.topWallCollission(ball.position.y, topWallY, rb.speed.y))
				rb.speed.y = -rb.speed.y;
			else if (Physics.bottomWallCollission(ball.position.y, bottomWallY, rb.speed.y))
				rb.speed.y = -rb.speed.y;
		}
	}

	/**
	 * 
	 * @param a The first ball
	 * @param b The second ball
	 * @param collissions A list of all collisions recorded so far.
	 * @return true if in the list of collissions, a and b exist in the same pair.
	 */
	private boolean hasCollided(GameObject a, GameObject b, ArrayList<GameObject[]> collissions) {
		for (GameObject[] coll : collissions) {
			if ((coll[0].equals(a) && coll[1].equals(b)) || (coll[0].equals(b) && coll[1].equals(a))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return false if isMoving() for all balls returns false.
	 */
	public boolean areBallsMoving() {
		for (int i = 0; i < balls.size(); i++) {
			RigidBody rb = (RigidBody) balls.get(i).getComponent(RigidBody.class);
			if (rb.isMoving()) {
				System.out.println("is moving");
				return true;
			}
		}
		return false;
	}

	/**
	 *  Use physics to calculate the new momentums for each collission pair.
	 */
	public void handleCollissions(ArrayList<GameObject[]> collissions) {
		for (GameObject[] coll : collissions) {
			GameObject go1 = coll[0];
			GameObject go2 = coll[1];
			go1.message(Message.ON_COLLISION, go2);
			go2.message(Message.ON_COLLISION, go1);
			RigidBody rb1 = (RigidBody) go1.getComponent(RigidBody.class);
			RigidBody rb2 = (RigidBody) go2.getComponent(RigidBody.class);

			Vector aMom = Physics.getNewMomentum(rb1.speed, rb2.speed, go1.position, go2.position);
			Vector bMom = Physics.getNewMomentum(rb2.speed, rb1.speed, go2.position, go1.position);
			rb1.setMomentum(aMom);
			rb2.setMomentum(bMom);
			
			Vector bToA = go1.position.sub(go2.position).norm();

			double dist = Config.Ball.SIZE - go1.position.distance(go2.position);
			go1.move(bToA.scale(dist));
			
			BallSprite b1 = (BallSprite) go1.getComponent(BallSprite.class);
			BallSprite b2 = (BallSprite) go2.getComponent(BallSprite.class);
			b1.isColliding = true;
			b2.isColliding = true;

		}
	}
}
