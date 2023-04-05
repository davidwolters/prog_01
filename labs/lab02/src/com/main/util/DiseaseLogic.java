package com.main.util;

import java.util.Random;

import com.main.village.Person;

public class DiseaseLogic {
	
	private static DiseaseLogic instance;
	private Person person;
	
	
	public DiseaseLogic(Person person) {
		this.person = person;
	}
	
	public boolean getIsInitalSick() {
		return Util.chance(Config.INIT_SICK_PROB);
	}
	
	public double getInfectProbability(boolean isVaccinated) {
		if (!isVaccinated) return Config.INIT_INFECT_PROB;
		boolean isProtected = Util.chance(Config.VACC_PROB);
		return Config.INIT_INFECT_PROB - (isProtected ? Config.VACC_PROTECTION : 0);
	}
	
	public boolean setIsSick() {
		if (!person.isSick()) return false;
		
		boolean newIsSick = Util.chance(Config.GET_WELL_PROB);
		
		person.setIsSick(newIsSick);
		return !newIsSick;
	}
	
	public void setIsDead() {
		if (!person.isSick() || person.isDead()) return;

		person.setIsDead(Util.chance(Config.DIE_PROB));
		person.setIsSick(!person.isDead());
	}
	
	public void infectAll(Person[] population) {
		if (!person.isSick() || person.isDead()) return;
		
		for (Person p: population) {
			if (p.equals(person))continue;
			person.infect(p);
		}
	}
	
	public boolean canInfect(Person victim) {
		return Util.distance(person, victim) <= Config.RANGE; 
	}
	
	public void setWillBeInfected(double infectProbability) {
		person.setIsSick(Util.chance(infectProbability) || person.isSick());
	}
}
