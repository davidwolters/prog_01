package com.pool.scenes;

import com.pool.components.GameObjectFactory;
import com.pool.ui.ScenePanel;

public class GameOverScene extends Scene {

	public GameOverScene(ScenePanel manager, boolean stripedWins) {
		super(manager);
		addGameObject(GameObjectFactory.makeWinSprite(stripedWins));
		addGameObject(GameObjectFactory.makePlayAgainButton());
		
		init();
	}

}
