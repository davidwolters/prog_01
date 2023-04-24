package com.pool.components;

import java.awt.Graphics2D;

import com.pool.util.Config;

public class Background extends Component {

	@Override
	protected void paint(Graphics2D g) {
		
		g.setColor(Config.Window.BG);
		
		g.fillRect(0, 0, Config.Window.W, Config.Window.H);
	}
}
