package com.pool.components.ball;

import java.awt.event.MouseEvent;

import com.pool.components.BallPhysicsHandler;
import com.pool.components.Component;
import com.pool.components.RigidBody;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.MouseEventType;
import com.pool.util.Vector;

public class QueueBallBehaviour extends Component {

	
	private boolean isOffSide = false;

	
	private Vector pickUpPos;
	private BallPhysicsHandler physics;
	private RigidBody rb;
	private BallAimBehaviour aimBehaviour;

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		gameObject.scene.addMouseListener(this);
		physics = (BallPhysicsHandler) gameObject.scene.findByTag(GameObjectTag.BALL_PHYSICS).getComponent(BallPhysicsHandler.class);
		rb = (RigidBody) gameObject.getComponent(RigidBody.class);
		aimBehaviour = (BallAimBehaviour) gameObject.getComponent(BallAimBehaviour.class);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	
	
	public void setIsOffSide(boolean isOffSide) {
		this.isOffSide = isOffSide;
		
		if (isOffSide) {
			gameObject.position = Config.Ball.OFFSIDE_POS;
			rb.speed = Vector.ZERO;
			aimBehaviour.disable();
			rb.disable();
		} else {
			aimBehaviour.enable();
			rb.enable();
		}
	}
	
	public boolean isOffSide() {
		return isOffSide;
	}
	
	@Override
	public void onMouseEvent(MouseEvent e, MouseEventType type) {
		Vector pos = new Vector(e);
		switch (type) {
		case CLICK:
			onClick(pos);
			return;
		case DRAG:
			onDrag(pos);
			return;
		case RELEASE:
			onRelease(pos);
			return;
		}
	}
	
	private void onClick(Vector pos) {
		if (!isOffSide) return;
		if (pos.distance(getPosition()) > Config.Ball.SIZE / 2) return;
		pickUpPos = pos;
	}
	
	private void onDrag(Vector pos) {
		if (pickUpPos == null) return;
		pickUpPos = pos;
		gameObject.position = pickUpPos;
	}
	
	private void onRelease(Vector pos) {
		if (pickUpPos == null) return;
		if (!physics.canPlaceQueueBall(pos)) {
			setIsOffSide(true);
			return;
		}
		pickUpPos = null;
		setIsOffSide(false);
	}
	
}
