package com.clock.util;

import java.util.Random;

public class Calc {

	public static int[][] getRandomPolygon(Vector start, double size, double randRange, int nPoints) {
		int[] xpoints = new int[nPoints];
		int[] ypoints = new int[nPoints];

		for (int i = 0; i < nPoints; i++) {
			Vector point =  start.getEndFromAngle(i*(360/nPoints), (Math.random() * (randRange)) + (size - randRange));
			
			xpoints[i] = point.getScaledX();
			ypoints[i] = point.getScaledY();
		}
		
		return new int[][] {xpoints, ypoints};
	}
}
