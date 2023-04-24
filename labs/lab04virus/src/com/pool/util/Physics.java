package com.pool.util; 
import com.pool.components.GameObject;


/**
 * Physics helper methods. 
 *
 */

public class Physics {
	
	/**
	 * @param a ball a
	 * @param b ball b
	 * @return true if the distance between the balls is less than one ball diameter.
	 */
	public static boolean ballsCollide(GameObject a, GameObject b) {
		return Vector.distance(a.position, b.position) < Config.Ball.SIZE;
	}

	/**
	 * @param ballX ball.position.x
	 * @param leftWallX the left wall's x-position.
	 * @param ballSpeedX ball's speed in x direction
	 * @return true if ball is moving towards ball and the distance between ball center and wall is less than one ball radius.
	 */
	public static boolean leftWallCollission(double ballX, double leftWallX, double ballSpeedX) {
		return ballX - (Config.Ball.SIZE / 2) < leftWallX && ballSpeedX < 0;
	}

	/**
	 * @param ballX ball.position.x
	 * @param rightWallX the right wall's x-position.
	 * @param ballSpeedX ball's speed in x direction
	 * @return true if ball is moving towards ball and the distance between ball center and wall is less than one ball radius.
	 */
	public static boolean rightWallCollission(double ballX, double rightWallX, double ballSpeedX) {
		return ballX + (Config.Ball.SIZE / 2) > rightWallX && ballSpeedX > 0;
	}

	/**
	 * @param ballX ball.position.y
	 * @param topWallX the top wall's y-position.
	 * @param ballSpeedY ball's speed in y direction
	 * @return true if ball is moving towards ball and the distance between ball center and wall is less than one ball radius.
	 */
	public static boolean topWallCollission(double ballY, double topWallY, double ballSpeedY) {
		return ballY - (Config.Ball.SIZE / 2) < topWallY && ballSpeedY < 0;
	}

	/**
	 * @param ballX ball.position.y
	 * @param bottomWallX the bottom wall's y-position.
	 * @param ballSpeedY ball's speed in y direction
	 * @return true if ball is moving towards ball and the distance between ball center and wall is less than one ball radius.
	 */
	public static boolean bottomWallCollission(double ballY, double bottomWallY, double ballSpeedY) {
		return ballY + (Config.Ball.SIZE / 2) > bottomWallY && ballSpeedY > 0;
	}
	
	/**
	 * Returns the normalised unit vector from ball a to ball b.
	 * @param aPos ball a's position
	 * @param bPos ball b's position
	 * @return
	 */
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
	
	public static Vector getNewMomentum(Vector aSpeed, Vector bSpeed, Vector aPos, Vector bPos) {
		
		Vector momStart = getMomentum(aSpeed);
		double impulse = getImpulseMag(aSpeed, bSpeed, aPos, bPos);
		Vector unit = getUnitVector(aPos, bPos);
		return new Vector(
			momStart.x + impulse*unit.x,
			momStart.y + impulse*unit.y
		);
	}
	
}
