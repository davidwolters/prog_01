package com.pool.components;

import com.pool.util.Config;
import com.pool.util.Vector;


/**
 * Component attached to objects that should move according to physics.
 */

public class RigidBody extends Component {

	
	// Expressed in px/s;
	public Vector speed = Vector.ZERO;
	
	@Override
	public void update() {
		super.update();
		
		// If we aren't moving fast enough, set speed to 0.
		if (!isMoving()) {
			stop();
			return;
		}
		
		// Since speed is expressed as px/s, we need to divide by FPS to know how far to move this frame.
		gameObject.move(Vector.scale(speed, 1/(double)Config.FPS));
		
		// Same here, since TABLE_FRICTIOn is also px/s^2
		double friction = Config.Ball.TABLE_FRICTION / (double)Config.FPS;
		speed = speed.sub(speed.norm().scale(friction));
	}
	
	
	/**
	 * @return true if speed is above a certain threshold.
	 */
	public boolean isMoving() {
		return speed.length() > Config.Ball.SPEED_THRESHOLD / (double)Config.FPS;
	}
	
	/**
	 * Set speed to (0,0)
	 */
	public void stop() {
		speed = Vector.ZERO;
	}
	
	
	/**
	 * Used for impulse calculations.
	 * @param momentum Speed vector with mass.
	 */
	public void setMomentum(Vector momentum) {
		this.speed = momentum.scale(1/Config.Ball.WEIGHT);
	}
}
