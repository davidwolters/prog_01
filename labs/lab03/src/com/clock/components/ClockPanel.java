package com.clock.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.DoubleAccumulator;

import javax.swing.*;

import com.clock.Config;
import com.clock.util.TimeHandType;
import com.clock.util.Vector;

public class ClockPanel extends ParentComponent implements ActionListener {
	
	private final Vector SIZE = new Vector(Config.WINDOW_W, Config.WINDOW_H);
	public static final Vector CENTER = new Vector(Config.WINDOW_W / 2, Config.WINDOW_H / 2);
	
	public ClockPanel() {
		this.setPreferredSize(SIZE.getScaledDimension());

		addTimeMarkers();
		addTimeHands();
		addFace();

		Timer timer = new Timer(Config.MILLIS_PER_SEC / Config.FPS, this);
		timer.start();
	}
	
	private void addTimeMarkers() {
		for (int i = 0; i < 60; i ++) {
			double angle = 90 - (i*6);
			boolean hour = i % 5 == 0;
			boolean minute = true;
			addComponent(new DiagonalLine(
					getTimeMarkerStart(angle, hour, minute),
					angle,
					getTimeMarkerLength(hour, minute),
					getTimeMarkerColor(hour, minute),
					getTimeMarkerWidth(hour, minute)
			));
		}
	}
	
	private double getTimeMarkerLength(boolean isHour, boolean isMinute) {
		if (isHour) return Config.Markers.H_LENGTH;
		if (isMinute) return Config.Markers.M_LENGTH;
		return Config.Markers.S_LENGTH;
	}
	
	private float getTimeMarkerWidth(boolean isHour, boolean isMinute) {
		if (isHour) return Config.Markers.H_WIDTH;
		if (isMinute) return Config.Markers.M_WIDTH;
		return Config.Markers.M_WIDTH;
	}
	
	private Vector getTimeMarkerStart(double angle, boolean isHour, boolean isMinute) {
		if (isHour) return CENTER.getEndFromAngle(angle, Config.CLOCK_RADIUS - (Config.Markers.H_LENGTH));
		if (isMinute) return CENTER.getEndFromAngle(angle, Config.CLOCK_RADIUS - (Config.Markers.M_LENGTH));
		return CENTER.getEndFromAngle(angle, Config.CLOCK_RADIUS - Config.Markers.S_LENGTH);
	}
	
	private Color getTimeMarkerColor(boolean isHour, boolean isMinute) {
		if (isHour) return Config.Markers.H_COLOR;
		if (isMinute) return Config.Markers.M_COLOR;
		return Config.Markers.S_COLOR;
	}
	
	
	private void addTimeHands() {
		addComponent(new TimeHand(CENTER, TimeHandType.HOUR));
		addComponent(new TimeHand(CENTER, TimeHandType.MINUTE));
		addComponent(new TimeHand(CENTER, TimeHandType.SECOND));
	}
	
	private void addFace() {
		addComponent(new ClockFace());
		addComponent(new DateMarker());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}

	@Override
	protected void beforePaint(Graphics2D g) {
		g.setColor(Config.BG);
		g.fillRect(0, 0, SIZE.getScaledX(), SIZE.getScaledY());
	}
	
	
}
