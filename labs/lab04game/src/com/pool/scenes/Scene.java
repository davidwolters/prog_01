package com.pool.scenes;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import com.pool.components.GameObject;
import com.pool.components.Component;
import com.pool.ui.ScenePanel;
import com.pool.util.GameObjectTag;

public abstract class Scene {
	
	public ArrayList<GameObject> gameObjects = new ArrayList<>();
	
	protected ScenePanel manager;

	public Scene(ScenePanel manager) {
		this.manager = manager;
	}
	
	public void update() {
		for (int i = 0; i < gameObjects.size(); i++) gameObjects.get(i).update();
	}
	
	public void init() {
		for (int i = 0; i < gameObjects.size(); i++) gameObjects.get(i).init();
	}
	
	public void paint(Graphics2D g) {
		for (int i = 0; i < gameObjects.size(); i++) gameObjects.get(i).paint(g);
	}
	
	public void addGameObject(GameObject go) {
		go.scene = this;
		gameObjects.add(go);
	}
	
	public void removeGameObject(GameObject go) {
		gameObjects.remove(go);
	}
	
	public void addMouseListener(Component mouseListener) {
		manager.mouseListeners.add(mouseListener);
	}
	
	public GameObject findByTag(GameObjectTag tag) {
		for (GameObject go : gameObjects) {
			if (go.tag == tag) return go;
		}
		return null;
	}
	
	public ArrayList<GameObject> findManyByTag(GameObjectTag tag) {
		ArrayList<GameObject> objects = new ArrayList<>();
		
		for (GameObject go : gameObjects) 
			if (go.tag == tag) objects.add(go);
		
		return objects;
	}
}
