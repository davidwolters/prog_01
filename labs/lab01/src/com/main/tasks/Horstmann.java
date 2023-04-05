package com.main.tasks;


public class Horstmann {
	public void tilingFloor(int w, int h) {
		
		char[][] floor = new char[h][w];
		boolean lastWhite = false;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				floor[i][j] = lastWhite ? '■' : ' '; 
				lastWhite = !lastWhite;
			}
			lastWhite = floor[i][0] == ' ';
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(floor[i][j]);
			}

			System.out.println();
		}
	}
	
	public String stampMachine(int usdIn, int stampCost) {
		int stamps = (100*usdIn)/stampCost;
		int remainder = (100*usdIn) % stampCost;
		
		return stamps + ", change: " + remainder;
	}
	
	public String middleOf(String input) {
		int l = input.length(); 
		if (l % 2 == 0) {
			return "" + input.charAt(l / 2) + input.charAt(l / 2 + 1);
		}
		return ""+input.charAt(l / 2);
	}
}
