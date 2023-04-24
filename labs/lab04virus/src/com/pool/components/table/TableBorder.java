package com.pool.components.table;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class TableBorder extends Component {
	@Override
	public void paint(Graphics2D g) {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		g.setColor(Config.Table.BORDER_COLOR);
		g.setStroke(new BasicStroke(w));
		g.drawRect(
			pos.x() - (w/2),
			pos.y() - (w/2),
			Config.Table.W + w,
			Config.Table.H + w
		);
	}

	public double getTopWallY() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.y + w/4;
	}

	public double getBottomWallY() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.y - w/4 + Config.Table.H;
	}

	public double getLeftWallX() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.x + w/4;
	}

	public double getRightWallX() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.x - w/4 + Config.Table.W;
	}


}
