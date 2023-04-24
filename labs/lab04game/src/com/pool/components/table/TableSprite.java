package com.pool.components.table;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class TableSprite extends Component {
	@Override
	public void paint(Graphics2D g) {
		Vector pos = gameObject.position;
		g.setColor(Config.Table.COLOR);
		g.fillRect(pos.x(), pos.y(), Config.Table.W, Config.Table.H);
		
	}

}
