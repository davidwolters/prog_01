package com.main.village;

import java.util.Random;

import com.main.util.Config;
import com.main.util.DiseaseLogic;
import com.main.util.Util;

public class Person {

    private boolean isSick;
    private boolean isDead = false;
    private double xPos;
    private double yPos;
    private int daysLeftImmune = 0;
    private double infectProb;

    private DiseaseLogic diseaseLogic;

    public Person(boolean isVaccinated) {
        diseaseLogic = new DiseaseLogic(this);
        isSick = diseaseLogic.getIsInitalSick();

        xPos = Util.getRandom().nextDouble() * 1000;
        yPos = Util.getRandom().nextDouble() * 1000;

        infectProb = diseaseLogic.getInfectProbability(isVaccinated);
    }

    public boolean isSick() {
        return isSick;
    }
    
    public void setIsSick(boolean isSick) {
    	this.isSick = isSick;
    }

    public boolean isDead() {
        return isDead;
    }
    
    public void setIsDead(boolean isDead) {
    	this.isDead = isDead;
    }
    
    
    public void dayPasses(Person[] allPersons) {
    	daysLeftImmune -= daysLeftImmune > 0 ? 1 : 0;
        
        if (diseaseLogic.setIsSick()) {
        	daysLeftImmune = Config.DAYS_IMMUNE;
        }
        
        diseaseLogic.setIsDead();
        
        diseaseLogic.infectAll(allPersons);
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public void infect(Person victim) {
        if (!diseaseLogic.canInfect(victim))
        	victim.becomesInfected();
    }

    public void becomesInfected() {
        if (isDead || daysLeftImmune > 0)
            return;

        diseaseLogic.setWillBeInfected(infectProb);
    }
}
