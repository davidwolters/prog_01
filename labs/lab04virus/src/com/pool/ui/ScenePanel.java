package com.pool.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.print.event.PrintJobAttributeEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.pool.scenes.Scene;
import com.pool.components.Component;
import com.pool.util.Config;
import com.pool.util.MouseEventType;
import com.pool.util.Vector;

public class ScenePanel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

	public static final Vector SIZE = new Vector(Config.Window.W * Config.Window.SCALE, Config.Window.H * Config.Window.SCALE);
	public static final Vector CENTER = new Vector(SIZE.x / 2, SIZE.y / 2); 
	
	private Scene scene;
	
	private boolean started = false;
	
	private Timer timer;


	public ArrayList<Component> mouseListeners = new ArrayList<>();
	
	public ScenePanel() {
		setPreferredSize(SIZE.getDimension());
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		timer = new Timer(Config.MILLIS_PER_SEC / Config.FPS, this);
	}
	
	
	public void start() {
		System.out.println("START");
		timer.start();
		started = true;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
		start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (scene == null) return; 
		scene.update();
		scene.paint((Graphics2D) g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	
	private void onMouseEvent(MouseEvent e, MouseEventType type) {
		for (int i = 0; i < mouseListeners.size(); i++) 
			mouseListeners.get(i).onMouseEvent(e, type);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		onMouseEvent(e, MouseEventType.CLICK);
	}


	@Override
	public void mouseClicked(MouseEvent e) {}


	@Override
	public void mouseReleased(MouseEvent e) {
		onMouseEvent(e, MouseEventType.RELEASE);
	}


	@Override
	public void mouseEntered(MouseEvent e) {}


	@Override
	public void mouseExited(MouseEvent e) {}


	@Override
	public void mouseDragged(MouseEvent e) {
		onMouseEvent(e, MouseEventType.DRAG);
	}


	@Override
	public void mouseMoved(MouseEvent e) {}
	
	public void stop() {
		timer.stop();
		started = false;
	}
	
	public void startStop() {
		if (started) stop();
		else start();
	}
}
