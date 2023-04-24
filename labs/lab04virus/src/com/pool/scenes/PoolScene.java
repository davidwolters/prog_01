package com.pool.scenes;

import java.util.ArrayList;

import com.pool.components.Component;
import com.pool.components.GameObject;
import com.pool.components.GameObjectFactory;
import com.pool.components.ball.BallWellnessBehaviour;
import com.pool.components.table.TableHoles;
import com.pool.components.table.TableSprite;
import com.pool.ui.ScenePanel;
import com.pool.ui.StatBar;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Vector;

public class PoolScene extends Scene {
	
	public PoolScene(ScenePanel panel) {
		super(panel);

		GameObject table = GameObjectFactory.makeTable(); 
		addGameObject(table);

		GameObject[] balls = GameObjectFactory.makeBalls(table, Config.Ball.NUM_BALLS);
		for (GameObject b : balls) addGameObject(b);
		
		addGameObject(GameObjectFactory.makeBallPhysicsHandler());
		
		init();
	}
	
	
	@Override
	public void update() {
		super.update();
		
		ArrayList<GameObject> balls = findManyByTag(GameObjectTag.BALL);
		
		int sick = 0;
		for (GameObject ball : balls) {
			BallWellnessBehaviour wellnessBehaviour = (BallWellnessBehaviour) ball.getComponent(BallWellnessBehaviour.class);
			if (wellnessBehaviour.isSick()) sick++;
		}
		
		StatBar.getInstance().setSick(sick);
	}
	
}
