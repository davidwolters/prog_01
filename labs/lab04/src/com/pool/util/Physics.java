package com.pool.util; 
import com.pool.components.GameObject;

public class Physics {
	public static boolean ballsCollide(GameObject a, GameObject b) {
		return Vector.distance(a.position, b.position) < Config.Ball.SIZE;
	}
}