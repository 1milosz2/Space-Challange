package com.company;

import java.util.Random;

public class U1 extends Rocket {

    private double cargoLimit;
    private double launchFailChancePercentage;
    private double landFailChancePercentage;

    public U1(int cost, int weightEmpty, int maxWeight, int launchFailChancePercentage, int landFailChancePercentage) {
        super(cost, weightEmpty, maxWeight);
        this.cargoLimit = maxWeight - weightEmpty;
        this.launchFailChancePercentage = launchFailChancePercentage;
        this.landFailChancePercentage = landFailChancePercentage;
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
