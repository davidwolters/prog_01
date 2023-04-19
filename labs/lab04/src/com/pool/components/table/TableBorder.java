package com.pool.components.table;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class TableBorder extends Component {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		Vector pos = getGlobalPosition();
		int w = Config.Table.BORDER_WIDTH;
		g.setColor(Config.Table.BORDER_COLOR);
		g.setStroke(new BasicStroke(w));
		g.drawRect(
			pos.getScaledX() - (w/2),
			pos.getScaledY() - (w/2),
			Vector.scaled(Config.Table.W) + (w),
			Vector.scaled(Config.Table.H) + (w)
		);
	}

}