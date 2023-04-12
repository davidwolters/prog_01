package com.pool.scenes;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.pool.components.GameObject;
import com.pool.ui.ScenePanel;
import com.pool.util.GameObjectTag;

public abstract class Scene {
	
	public ArrayList<GameObject> gameObjects = new ArrayList<>();
	
	protected ScenePanel manager;

	public Scene(ScenePanel manager) {
		this.manager = manager;
	}
	
	public void update() {
		for (GameObject go : gameObjects) go.update();
	}
	
	public void paint(Graphics2D g) {
		for (GameObject go : gameObjects) go.paint(g);
	}
	
	public void addGameObject(GameObject go) {
		gameObjects.add(go);
	}
	
	public GameObject findByTag(GameObjectTag tag) {
		for (GameObject go : gameObjects) {
			if (go.tag == tag) return go;
		}
		return null;
	}
}
