package com.pool.util; 
import com.pool.components.GameObject;

public class Physics {
	public static boolean ballsCollide(GameObject a, GameObject b) {
		return Vector.distance(a.position, b.position) < Config.Ball.SIZE;
	}
	
	
	public static boolean leftWallCollission(double ballX, double leftWallX, double ballSpeedX) {
		return ballX - (Config.Ball.SIZE / 2) < leftWallX && ballSpeedX < 0;
	}

	public static boolean rightWallCollission(double ballX, double rightWallX, double ballSpeedX) {
		return ballX + (Config.Ball.SIZE / 2) > rightWallX && ballSpeedX > 0;
	}

	public static boolean topWallCollission(double ballY, double topWallY, double ballSpeedY) {
		return ballY - (Config.Ball.SIZE / 2) < topWallY && ballSpeedY < 0;
	}

	public static boolean bottomWallCollission(double ballY, double bottomWallY, double ballSpeedY) {
		return ballY + (Config.Ball.SIZE / 2) > bottomWallY && ballSpeedY > 0;
	}
	
	
	public static Vector getUnitVector(Vector aPos, Vector bPos) {
		double dist = Vector.distance(aPos, bPos);
		return new Vector(
			(aPos.x - bPos.x) / dist,
			(aPos.y - bPos.y) / dist
		);
	}
	
	public static Vector getMomentum(Vector speed) {
		return speed.scale(Config.Ball.WEIGHT);
	}
	
	public static double getImpulseMag(Vector aSpeed, Vector bSpeed, Vector aPos, Vector bPos) {
		Vector aMom = getMomentum(aSpeed);
		Vector bMom = getMomentum(bSpeed);
		Vector d = getUnitVector(aPos, bPos);
		return bMom.scalar(d) - aMom.scalar(d);
	}
	
	public static Vector getNewMomentum(Vector aSpeed, Vector bSpeed, Vector aPos, Vector bPos, int impulseMult) {
		
		Vector momStart = getMomentum(aSpeed);
		double impulse = getImpulseMag(aSpeed, bSpeed, aPos, bPos);
		Vector unit = getUnitVector(aPos, bPos);
		return new Vector(
			momStart.x + impulse*unit.x*impulseMult,
			momStart.y + impulse*unit.y*impulseMult
		);
	}
	
}
