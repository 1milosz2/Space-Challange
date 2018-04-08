package com.company;

import java.util.Random;

public class U1 extends Rocket {

    private int cargoLimit;
    private int launchFailChancePercentage;
    private int landFailChancePercentage;

    U1(int cost, int weightEmpty, int maxWeight, int launchFailChancePercentage, int landFailChancePercentage) {
        super(cost, weightEmpty, maxWeight);
        this.cargoLimit = maxWeight - weightEmpty;
        this.launchFailChancePercentage = launchFailChancePercentage;
        this.landFailChancePercentage = landFailChancePercentage;
    }

    @Override
    public boolean land() {
        int random = new Random().nextInt(100);
        return random >= landFailChancePercentage * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
    }

    @Override
    public boolean launch() {
        int random = new Random().nextInt(100);
        return random >= launchFailChancePercentage * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
    }
}
