package com.pool.components;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.pool.scenes.Scene;
import com.pool.util.GameObjectTag;
import com.pool.util.Message;
import com.pool.util.Vector;


/**
 * The class for a gameObject, which essentially is a position and a container of components.
 * @author david
 *
 */
public class GameObject {
	
	// Position on screen.
	public Vector position;
	
	
	// Identifier, not necessarily unique.
	public GameObjectTag tag;
	
	// All components.
	public ArrayList<Component> components = new ArrayList<>();
	
	// Reference to scene object.
	public Scene scene;


	public GameObject(GameObjectTag tag, Vector position) {
		this.position = position;
		this.tag = tag;
	}

	// Will be called once per frame, draw all components.
	public void paint(Graphics2D g) {
		for (Component c : components) {
			c.paint(g);
		}
	}
	
	// Will be called once per frame, update all components.
	public void update() {
		for (Component c : components) c.update();
	}

	
	// Add a new component to the gameObject.
	public void addComponent(Component c) {
		components.add(c);
		c.gameObject = this;
	}
	
	// Initialize all components.
	public void init() {
		for (Component c : components) c.init();
	}
	
	
	// Return a component of a certain class. 
	public <T extends Component> Component getComponent(Class<T> compClass) {
		for (Component c: components) {
			if (compClass.isInstance(c)) {
				return c;
			}
		}
		return null;
	}
	
	
	// Called to receive a message from another gameObject.
	public void message(Message message, GameObject sender) {
		for (Component c: components)
			c.onMessage(message, sender);
	}
	
	// Move the gameobject.
	public void move(Vector distance) {
		this.position = Vector.add(this.position, distance);
	}
	
	public void destroy() {
		scene.removeGameObject(this);
	}
}
