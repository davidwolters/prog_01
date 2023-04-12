package com.pool.components.table;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class TableSprite extends Component {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		Vector pos = getGlobalPosition();
		g.setColor(Config.Table.COLOR);
		g.fillRect(pos.getScaledX(), pos.getScaledY(), Vector.scaled(Config.Table.W), Vector.scaled(Config.Table.H));
		
	}

}
