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
		int tableH = Config.Table.H;
		int tableW = Config.Table.W;

		g.setColor(Config.Table.BORDER_COLOR);
		g.setStroke(new BasicStroke(1));
		
		
		g.fillRect(pos.x() - w, pos.y() - w, w, tableH + w*2);
		g.fillRect(pos.x(), pos.y() - w, tableW, w);
		g.fillRect(pos.x() + tableW, pos.y() - w, w, tableH + w*2);
		g.fillRect(pos.x(), pos.y() + tableH, tableW, w);
	}

	public double getTopWallY() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.y;
	}

	public double getBottomWallY() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.y + Config.Table.H;
	}

	public double getLeftWallX() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.x;
	}

	public double getRightWallX() {
		Vector pos = gameObject.position;
		int w = Config.Table.BORDER_WIDTH;
		return pos.x + Config.Table.W;
	}


}
