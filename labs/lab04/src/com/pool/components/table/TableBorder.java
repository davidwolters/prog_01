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
		g.setStroke(new BasicStroke(1));
		g.setColor(Color.RED);
		g.drawLine(0, (int) getTopWallY(), 1000, (int) getTopWallY());
		g.drawLine(0, (int) getBottomWallY(), 1000, (int) getBottomWallY());
		g.drawLine((int) getLeftWallX(), 0, (int) getLeftWallX(), 1000);
		g.drawLine((int) getRightWallX(), 0, (int) getRightWallX(), 1000);
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
