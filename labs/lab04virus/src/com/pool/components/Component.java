package com.pool.components;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.IllegalPathStateException;

import javax.swing.text.Position;

import com.pool.util.Message;
import com.pool.util.Vector;
import com.pool.util.MouseEventType;

/**
 * Base class for all component behaviours.
 */
public abstract class Component {
	
	// Reference to the gameObject we are attached to.
	protected GameObject gameObject;
	
	public void setGameObject(GameObject go) {
		gameObject = go;
	}

	// Will be called each frame.
	public void update() {};
	
	// Will be called each frame.
	public void paint(Graphics2D g) {};
	
	// Will be called once all gameobjects have been instanciated.
	public void init() {}; 
	
	public Vector getPosition() {
		return gameObject.position;
	}
	
	public void setPosition(Vector position) {
		gameObject.position = position;
	}
	
	// Messaging service, so that gameObjects can send messages between eachother.
	public void onMessage(Message message, GameObject go) {}
	
	// Components can subscribe to the scene's mouselisteners, and if so will recieve mouse messages via this method.
	public void onMouseEvent(MouseEvent e, MouseEventType type) {}
}

