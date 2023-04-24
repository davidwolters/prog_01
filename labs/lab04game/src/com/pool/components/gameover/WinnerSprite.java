package com.pool.components.gameover;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class WinnerSprite extends Component {
	
	private String text;
	
	public WinnerSprite(boolean stripedWins) {
		text = stripedWins ? Config.GameOver.STRIPED_WINS : Config.GameOver.SOLID_WINS;
	}

	@Override
	protected void paint(Graphics2D g) {
		
		g.setFont(Config.GameOver.FONT);
		
		int width = g.getFontMetrics().stringWidth(text);
		
		Vector center = Vector.offsetCenter(new Vector(width, Config.GameOver.FONT_SIZE));
		
		g.drawString(text, center.x(), center.y());
	}
}
