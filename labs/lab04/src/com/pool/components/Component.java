package com.pool.components;

import java.awt.Graphics2D;
import java.awt.geom.IllegalPathStateException;

import javax.swing.text.Position;

import com.pool.util.Message;
import com.pool.util.Vector;

public abstract class Component {
	
	protected GameObject gameObject;
	
	public void setGameObject(GameObject go) {
		gameObject = go;
	}

	public abstract void update();
	public void paint(Graphics2D g) {};
	
	
	public void init() {}; 
	
	public Vector getPosition() {
		return gameObject.position;
	}
	
	public void setPosition(Vector position) {
		gameObject.position = position;
	}
	
	public Vector getGlobalPosition() {
		return gameObject.getGlobalPosition();
	}
	
	public void setGlobalPosition(Vector position) {
		gameObject.setGlobalPosition(position);
	}
	
	
	public void onMessage(Message message, GameObject go) {}
}
