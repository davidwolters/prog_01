package com.pool.components;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.pool.scenes.Scene;
import com.pool.util.GameObjectTag;
import com.pool.util.Message;
import com.pool.util.Vector;

public class GameObject {
	public Vector position;
	
	public GameObject parent;
	public GameObjectTag tag;
	
	public ArrayList<Component> components = new ArrayList<>();
	
	public ArrayList<GameObject> children = new ArrayList<>();
	
	public Scene scene;
	
	public GameObject(GameObjectTag tag, Vector position) {
		this.position = position;
		this.tag = tag;
		setComponentObjectReference();
	}

	public void paint(Graphics2D g) {
		for (Component c : components) {
			c.paint(g);
		}
	}
	
	public void update() {
		for (Component c : components) c.update();
	}

	
	private void setComponentObjectReference() {
		for (Component c : components) c.setGameObject(this);
	}
	
	public void addComponent(Component c) {
		components.add(c);
		c.gameObject = this;
	}
	
	public void init() {
		for (Component c : components) c.init();
	}
	
	public void addChild(GameObject child) {
		children.add(child);
		child.setParent(this);
	}
	
	public void setParent(GameObject parent) {
		this.parent = parent;
	}
	
	
	public <T extends Component> Component getComponent(Class<T> compClass) {
		for (Component c: components) {
			if (compClass.isInstance(c)) {
				return c;
			}
		}
		return null;
	}
	
	
	public void message(Message message, GameObject sender) {
		for (Component c: components)
			c.onMessage(message, sender);
	}
	
	public void move(Vector distance) {
		this.position = Vector.add(this.position, distance);
	}
	
	public void destroy() {
		scene.removeGameObject(this);
	}
}
