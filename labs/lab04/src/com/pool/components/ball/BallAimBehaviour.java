package com.pool.components.ball;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import com.pool.util.MouseEventType;
import com.pool.util.*;
import com.pool.components.*;
public class BallAimBehaviour extends Component {

	
	private Vector aimPosition = null;
	
	private RigidBody rb;
	private BallPhysicsHandler physics;

	@Override
	public void init() {
		gameObject.scene.addMouseListener(this);
		rb = (RigidBody) gameObject.getComponent(RigidBody.class);
		physics = (BallPhysicsHandler) gameObject.scene
				.findByTag(GameObjectTag.BALL_PHYSICS)
				.getComponent(BallPhysicsHandler.class);
	}
	

	@Override
	public void onMouseEvent(MouseEvent e, MouseEventType type) {
		switch (type) {
		case CLICK:
			onClick(e);
			return;
		case RELEASE:
			onRelease(e);
			return;
		case DRAG:
			onDrag(e);
			return;
		}
	}
	
	private void onClick(MouseEvent e) {
		if (new Vector(e).distance(getPosition()) > Config.Ball.SIZE) return;
		if (physics.areBallsMoving()) return;
		aimPosition = new Vector(e);
	}
	
	private void onRelease(MouseEvent e) {
		if (aimPosition == null) return;
		shoot();
	}
	
	private void onDrag(MouseEvent e) {
		if (aimPosition == null) return;
		aimPosition = new Vector(e);
	}
	
	private void shoot() {
		double mag = aimPosition.distance(getPosition()) * Config.Ball.AIM_MULTIPLIER;
		Vector dir = getPosition().sub(aimPosition).norm();
		rb.speed = dir.scale(mag);
		aimPosition = null;
	}

	@Override
	public void update() {
		
	}
	
	@Override
	public void paint(Graphics2D g) {
		if (aimPosition == null) return;
		
		Vector aimVec = aimPosition.sub(getPosition());
		Vector lineStart = getPosition().add(aimVec);
		Vector lineEnd = getPosition().sub(aimVec);
		
		g.setColor(Config.Ball.AIM_COLOR);
		g.drawLine(lineStart.x(), lineStart.y(), lineEnd.x(), lineEnd.y());
	}
	
}
