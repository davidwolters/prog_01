package com.pool.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.pool.components.table.TableBorder;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Physics;
import com.pool.util.Vector;

public class BallPhysicsHandler extends Component {
	
	
	private ArrayList<GameObject> balls = new ArrayList();
	
	private double leftWallX, rightWallX, topWallY, bottomWallY;
	
	@Override
	public void init() {
		super.init();
		balls = gameObject.scene.findManyByTag(GameObjectTag.BALL);
		
		TableBorder border = (TableBorder) gameObject.scene.findByTag(GameObjectTag.TABLE).getComponent(TableBorder.class);
		leftWallX = border.getLeftWallX();
		rightWallX = border.getRightWallX();
		topWallY = border.getTopWallY();
		bottomWallY = border.getBottomWallY();
	}

	@Override
	public void update() {

		checkBallToBallCollissions();
		checkBallToWallCollissions();
	}
	
	
	private void checkBallToBallCollissions() {
		ArrayList<GameObject[]> collissions = new ArrayList();
		for (GameObject ball : balls) {
			for (GameObject other : balls) {
				if (ball.equals(other)) continue;
				if (hasCollided(ball, other, collissions)) continue;
				if (Physics.ballsCollide(ball, other)) {
					collissions.add(new GameObject[] {ball, other});
				}
			}
		}
		handleCollissions(collissions);	
	}
	
	private void checkBallToWallCollissions() {
		for (GameObject ball : balls) {
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
	
	
	@Override
	public void paint(Graphics2D g) {
		int s = Config.Ball.SIZE / 2;
		for (GameObject ball : balls) {
			g.setColor(Color.BLUE);
			g.drawRect((int) ball.position.x - s, (int) ball.position.y - s, s*2, s*2);
		}
	}
	
	private boolean hasCollided(GameObject a, GameObject b, ArrayList<GameObject[]> collissions) {
		for (GameObject[] coll : collissions) {
			if ((coll[0].equals(a) && coll[1].equals(b)) || (coll[0].equals(b) && coll[1].equals(a))) {
				return true;
			}
		}
		return false;
	}
	
	public void handleCollissions(ArrayList<GameObject[]> collissions) {
		for (GameObject[] coll : collissions) {
			RigidBody a = (RigidBody) coll[0].getComponent(RigidBody.class);
			RigidBody b = (RigidBody) coll[1].getComponent(RigidBody.class);
		
			Vector aMom = Physics.getNewMomentum(a.speed, b.speed, coll[0].position, coll[1].position, 1);
			Vector bMom = Physics.getNewMomentum(b.speed, a.speed, coll[1].position, coll[0].position, 1);
			a.setMomentum(aMom);
			b.setMomentum(bMom);
		}
	}
}
