package com.main.village;

public class Village {
    public static final int SIZE = 1000;

    private Person[] population = new Person[SIZE];

    public Village(boolean isVaccinated) {
        initiatePopulation(isVaccinated);
    }

    private void initiatePopulation(boolean isVaccinated) {
        for (int i = 0; i < SIZE; i++) {
            population[i] = new Person(isVaccinated);
        }
    }

    public int countSick() {
        int sick = 0;

        for (Person person : population) {
            sick += person.isSick() ? 1 : 0;
        }
        return sick;
    }

    public int countDead() {
        int dead = 0;
        for (Person person : population) {
            dead += person.isDead() ? 1 : 0;
        }
        return dead;
    }

    public void dayPassesAll() {
        for (Person person : population) {
            person.dayPasses(population);
        }
    }
}
