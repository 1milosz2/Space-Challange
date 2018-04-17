package com.company;

public class U2 extends Rocket {

    public U2() {
        cost = 120;
        weightEmpty = 18000;
        weightCurrent = weightEmpty;
        maxWeight = 29000;
        launchFailChancePercentage = 4;
        landFailChancePercentage = 8;
        cargoLimit = maxWeight - weightEmpty;
    }
}
