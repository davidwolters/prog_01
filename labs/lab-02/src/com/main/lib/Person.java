package com.main.lib;

import java.util.Random;

import javax.sql.DataSource;

import com.main.conf.Config;
import com.main.conf.Util;

public class Person {
    private final double INIT_SICK_PROB = 0.2;
    private final double GET_WELL_PROB = 0.3;
    private final double DIE_PROB = 0.1;
    private final double INIT_INFECT_PROB = 0.1;
    private final double RANGE = 10;
    private final int DAYS_IMMUNE = 100;
    private final double VACC_PROB = 0.2;
    private final double VACC_PROTECTION = 0.05;
    private boolean isSick;
    private boolean isDead = false;
    private double xPos;
    private double yPos;
    private int daysLeftImmune = 0;
    private double infectProb = INIT_INFECT_PROB;

    private Random random;

    public Person(boolean isVaccinated) {
        random = Config.getRandom();
        isSick = random.nextFloat() <= INIT_SICK_PROB;
        xPos = random.nextDouble() * 1000;
        yPos = random.nextDouble() * 1000;

        infectProb = INIT_INFECT_PROB - (isVaccinated ? (random.nextDouble() < VACC_PROB ? VACC_PROTECTION : 0) : 0);
    }

    public boolean isSick() {
        return isSick;
    }

    public boolean isDead() {
        return isDead;
    }

    public void dayPasses(Person[] allPersons) {

        daysLeftImmune = Math.max(0, --daysLeftImmune);

        if (isSick) {
            isSick = Config.getRandom().nextDouble() <= GET_WELL_PROB ? false : isSick;
            if (!isSick) {
                daysLeftImmune = DAYS_IMMUNE;
            }
        }

        if (!isDead) {
            isDead = isSick && Config.getRandom().nextDouble() <= DIE_PROB;
        }

        if (!isSick)
            return;
        for (Person person : allPersons) {
            if (person.equals(this))
                continue;
            infect(person);
        }
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    private void infect(Person victim) {
        if (Util.distance(this, victim) < RANGE)
            return;
        victim.becomesInfected();
    }

    public void becomesInfected() {
        if (isDead || daysLeftImmune > 0)
            return;

        isSick = Config.getRandom().nextDouble() <= infectProb ? true : isSick;
    }
}
