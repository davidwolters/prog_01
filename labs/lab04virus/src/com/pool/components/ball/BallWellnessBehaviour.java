package com.pool.components.ball;

import com.pool.components.Component;
import com.pool.components.GameObject;
import com.pool.ui.StatBar;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Message;

public class BallWellnessBehaviour extends Component {
	
	
	private boolean isSick = false;
	
	public BallWellnessBehaviour(boolean isSick) {
		this.isSick = isSick;
	}

	@Override
	public void update() {
		if (!isSick) return;
		
		if (Math.random() < Config.Ball.RECOVER_CHANCE) isSick = false;
		else if (Math.random() < Config.Ball.DIE_CHANCE) die();
	}
	
	
	public boolean isSick() {
		return isSick;
	}
	
	@Override
	public void onMessage(Message message, GameObject go) {
		if (message != Message.ON_COLLISION) return;
		if (go.tag != GameObjectTag.BALL) return;
		
		BallWellnessBehaviour other = (BallWellnessBehaviour) go.getComponent(BallWellnessBehaviour.class);
		
		if (other.isSick && this.isSick) return;
		if (this.isSick) other.onCollissionWithSick();
		else onCollissionWithSick();
	}
	
	public void onCollissionWithSick() {
		System.out.println("here");
		if (Math.random() < Config.Ball.INFECT_CHANCE) isSick = !isSick;
	}

	
	public void die() {
		StatBar.getInstance().increaseDead();
		gameObject.destroy();
	}
}
