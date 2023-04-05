package com.main.util;

import static java.lang.Math.*;

import java.util.Random;

import com.main.village.*;


public class Util {
    public static double distance(double x1, double y1, double x2, double y2) {
        return sqrt(abs(pow(x2 - x1, 2) - pow(y2 - y1, 2)));
    }

    public static double distance(Person p1, Person p2) {
        return distance(p1.getXPos(), p1.getYPos(), p2.getXPos(), p2.getYPos());
    }
    
    private static Random random;

    public static Random getRandom() {
        if (random == null) {
            random = new Random();
        }

        return random;
    }
    
    public static boolean chance(double chance) {
    	return getRandom().nextDouble() <= chance;
    }
}
