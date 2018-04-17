package com.company;

import java.util.Random;

public class Rocket implements SpaceShip {

    int cost;
    int weightEmpty;
    int weightCurrent;
    int maxWeight;
    double launchFailChancePercentage;
    double landFailChancePercentage;
    int cargoLimit = maxWeight - weightEmpty;

    Rocket() {
    }

    public boolean launch() {
        int random = new Random().nextInt(100);
        double chanceCalculation = getLaunchFailChancePercentage() * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
        return random >= chanceCalculation;
    }

    public boolean land() {
        int random = new Random().nextInt(100);
        double chanceCalculation = getLandFailChancePercentage() * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
        return random >= chanceCalculation;
    }

    public final boolean canCarry(Item item) {
        return weightCurrent + item.getWeight() <= maxWeight;
    }

    public final void carry(Item item) {
        weightCurrent += item.getWeight();
    }

    public int getCost() {
        return cost;
    }

    public int getWeightCurrent() {
        return weightCurrent;
    }

    public int getWeightEmpty() {
        return weightEmpty;
    }

    public double getLaunchFailChancePercentage() {
        return launchFailChancePercentage;
    }

    public double getLandFailChancePercentage() {
        return landFailChancePercentage;
    }

}
