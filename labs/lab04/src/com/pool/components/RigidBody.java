package com.pool.components;

import com.pool.util.Config;
import com.pool.util.Vector;

public class RigidBody extends Component {

	
	// Expressed in px/s^2;
	public Vector acceleration = Vector.ZERO;
	// Expressed in px/s;
	public Vector speed = Vector.ZERO;
	public boolean fixed = false;
	
	@Override
	public void update() {
		
		if (!isMoving()) {
			stop();
			return;
		}

		speed = Vector.add(speed, Vector.scale(acceleration, 1/(double)Config.FPS));
		gameObject.move(Vector.scale(speed, 1/(double)Config.FPS));
//		System.out.println(speed +  " (" + speed.length() + ")" + ", " + acceleration);
		
		double friction = Config.Ball.TABLE_FRICTION / (double)Config.FPS;
		acceleration = acceleration.sub(speed.norm().scale(friction));
	}
	
	
	public boolean isMoving() {
		return speed.length() > Config.Ball.SPEED_THRESHOLD / (double)Config.FPS;
	}
	
	public void stop() {
		acceleration = Vector.ZERO;
		speed = Vector.ZERO;
	}
	
	public void setMomentum(Vector momentum) {
		this.speed = momentum.scale(1/Config.Ball.WEIGHT);
	}
}
