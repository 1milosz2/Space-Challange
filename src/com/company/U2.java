package com.company;

import java.util.Random;

public class U2 extends Rocket {

    private int cargoLimit;
    private int launchFailChancePercentage;
    private int landFailChancePercentage;

    U2() {
        setCost(120);
        setWeightEmpty(18000);
        setMaxWeight(29000);
        this.cargoLimit = getMaxWeight() - getWeightEmpty();
        this.launchFailChancePercentage = 4;
        this.landFailChancePercentage = 8;
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
