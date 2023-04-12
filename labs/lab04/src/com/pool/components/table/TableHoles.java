package com.pool.components.table;

import java.awt.Color;
import java.awt.Graphics2D;

import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.Vector;

public class TableHoles extends Component {

	private Vector[] holesPos = new Vector[6];

	@Override
	public void init() {
		calcHolesPosition();
	}

	public void calcHolesPosition() {
		Vector tablePos = gameObject.position;
		int inset = Config.Table.HOLE_INSET;
		Vector size = Config.Table.SIZE;
		int w = size.getScaledX();
		int h = size.getScaledY();
		int d = Config.Table.HOLE_D;
		holesPos[0] = Vector.add(tablePos, new Vector(inset, inset));
		holesPos[1] = Vector.add(tablePos, new Vector(w/2 - (d/2), inset));
		holesPos[2] = Vector.add(tablePos, new Vector(w - d - inset, inset));
		holesPos[3] = Vector.add(tablePos, new Vector(inset, h - inset - d));
		holesPos[4] = Vector.add(tablePos, new Vector(w/2 - (d/2), h - inset - d));
		holesPos[5] = Vector.add(tablePos, new Vector(w - inset - d, h - inset - d));
	}

	@Override
	public void update() {
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(Config.Table.HOLE_COLOR);
		for (Vector hp : holesPos) {
			g.fillOval(hp.getScaledX(), hp.getScaledY(), Config.Table.HOLE_D, Config.Table.HOLE_D);
		}
	}
}
