package com.pool.components;

import com.pool.util.Config;
import com.pool.util.Vector;

public class RigidBody extends Component {

	
	// Expressed in px/s^2;
	public Vector acceleration;
	// Expressed in px/s;
	public Vector speed = Vector.ZERO;
	public boolean fixed = false;
	
	
	@Override
	public void update() {
		if (!fixed) {
			speed = Vector.add(speed, Vector.scale(acceleration, 1/(double)Config.FPS));
			gameObject.move(Vector.scale(speed, 1/(double)Config.FPS));
			System.out.println(speed + ", " + acceleration);
		}
	}
}
