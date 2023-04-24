package com.pool.components.gameover;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import com.pool.components.Component;
import com.pool.ui.ScenePanel;
import com.pool.util.Config;
import com.pool.util.MouseEventType;
import com.pool.util.Vector;

public class PlayAgainButton extends Component {

	
	private Vector start;
	private int width;

	
	@Override
	public void init() {
		super.init();
		
		gameObject.scene.addMouseListener(this);
	}
	
	@Override
	protected void paint(Graphics2D g) {
		super.paint(g);
		
		
		g.setFont(Config.GameOver.FONT);
		width = g.getFontMetrics().stringWidth(Config.GameOver.PLAY_AGAIN);
		
		start = Vector.offsetCenter(new Vector(width, Config.GameOver.FONT_SIZE)).add(new Vector(0, Config.GameOver.BUTTON_GAP));
		
		g.setColor(Config.GameOver.PLAY_AGAIN_COLOR);
		g.drawString(Config.GameOver.PLAY_AGAIN, start.x(), start.y());
	}
	
	
	@Override
	public void onMouseEvent(MouseEvent e, MouseEventType type) {
		
		if (type != MouseEventType.CLICK) return;
		if (start == null) return;
		
		Vector pos = new Vector(e);
		Vector rStart = start.sub(new Vector(0, Config.GameOver.FONT_SIZE));
		Vector end = start.add(new Vector(width, Config.GameOver.FONT_SIZE));
		System.out.println("HERE");
		
		if (pos.x > rStart.x && pos.x < end.x && pos.y > rStart.y && pos.y < end.y) {
			System.out.println("ALSO HERE");
			ScenePanel.startOver();
		}
	}
}
