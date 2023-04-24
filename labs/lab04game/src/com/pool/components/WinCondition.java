package com.pool.components;

import java.util.ArrayList;

import com.pool.components.ball.BallSprite;
import com.pool.ui.ScenePanel;
import com.pool.util.GameObjectTag;

public class WinCondition extends Component {

	
	private boolean stripedTurn = false;
	
	private ArrayList<GameObject> balls = new ArrayList<>();
	
	@Override
	public void update() {
		balls = gameObject.scene.findManyByTag(GameObjectTag.BALL);
		
		checkForWin();
	}
	
	private void checkForWin() {
		boolean hasStripedBalls = false;
		boolean hasSolidBalls = false;
		for (GameObject ball : balls) {
			BallSprite bs = (BallSprite) ball.getComponent(BallSprite.class);
			if (bs.isStriped()) {
				hasStripedBalls = true;
			} else if (bs.isSolid()) hasSolidBalls = true;
		}
		
		if (!hasSolidBalls || !hasStripedBalls) {
			ScenePanel.gameOver(!hasStripedBalls);
		}
	}
	
	
	public void nextTurn() {
		stripedTurn = !stripedTurn;
	}
}
