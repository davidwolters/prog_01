package com.pool.scenes;

import java.util.ArrayList;

import com.pool.components.Component;
import com.pool.components.GameObject;
import com.pool.components.GameObjectFactory;
import com.pool.components.WinCondition;
import com.pool.components.table.TableHoles;
import com.pool.components.table.TableSprite;
import com.pool.ui.ScenePanel;
import com.pool.util.Config;
import com.pool.util.GameObjectTag;
import com.pool.util.Vector;

public class PoolScene extends Scene {
	
	public PoolScene(ScenePanel panel) {
		super(panel);

		
		addGameObject(GameObjectFactory.makeBG());
		GameObject table = GameObjectFactory.makeTable(); 
		addGameObject(table);

		GameObject[] balls = GameObjectFactory.makeBalls(table, Config.Ball.NUM_BALLS);
		for (GameObject b : balls) addGameObject(b);
		
		addGameObject(GameObjectFactory.makeBallPhysicsHandler());
		addGameObject(GameObjectFactory.makeWinCondition());
		
		
		System.out.println("INITALIZED");
		
		init();
	}
	
}
