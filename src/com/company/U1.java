package com.company;

import java.util.Random;

public class U1 extends Rocket {

    private double cargoLimit;
    private double launchFailChancePercentage;
    private double landFailChancePercentage;

    public U1() {
        setCost(100);
        setWeightEmpty(10000);
        setMaxWeight(18000);
        this.cargoLimit = getMaxWeight() - getWeightEmpty();
        this.launchFailChancePercentage = 5;
        this.landFailChancePercentage = 1;
    }

    @Override
    public boolean land() {
        int random = new Random().nextInt(100);
        double chanceCalculation = landFailChancePercentage * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
        return random >= chanceCalculation;
    }

    @Override
    public boolean launch() {
        int random = new Random().nextInt(100);
        double chanceCalculation = launchFailChancePercentage * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
        return random >= chanceCalculation;
    }
}
