package com.pool.components;

import com.pool.util.Vector;

public class RigidBody extends Component {

	
	public Vector acceleration;
	public boolean fixed = false;
	
	
	@Override
	public void update() {
		if (!fixed) this.gameObject.move(acceleration);
	}
}
