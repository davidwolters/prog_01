package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import com.main.lib.Logger;
import com.main.village.Village;

public class App {

    public static void main(String[] args) {

        
        
        int totNoVacDead = 0;
        int totVacDead = 0;

        int total = 1000;
        for (int i = 0; i < total; i++) {
        	boolean vacc = i > total / 2;
            Village v = new Village(vacc);
            do {
                v.dayPassesAll();
            } while (v.countSick() > 0);

            totVacDead += vacc ? v.countDead() : 0;
            totNoVacDead += vacc ? 0 : v.countDead() ;
            Logger.log("V(" + (vacc ? "vacc)" : "nova)") + " sick: " + v.countSick() + ", dead: " + v.countDead());
        }
        
        System.out.println("novac: " + ((double)totNoVacDead/1000) + ", vac: " + ((double)totVacDead/1000));

    }

}
