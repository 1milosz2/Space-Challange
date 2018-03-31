package com.company;

import java.util.Random;

public class U2 extends Rocket {

    private int cargoLimit;
    private int launchFailChancePercentage;
    private int landFailChancePercentage;

    public U2(int cost, int weightEmpty, int maxWeight, int launchFailChancePercentage, int landFailChancePercentage) {
        super(cost, weightEmpty, maxWeight);
        this.cargoLimit = maxWeight - weightEmpty;
        this.launchFailChancePercentage = launchFailChancePercentage;
        this.landFailChancePercentage = landFailChancePercentage;
    }

    @Override
    public boolean land() {
        int random = new Random().nextInt(100);
        if (random < landFailChancePercentage * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit)) {
            return false;
        } else return true;
    }

    @Override
    public boolean launch() {
        int random = new Random().nextInt(100);
        if (random < launchFailChancePercentage * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit)) {
            return false;
        } else return true;
    }
}
