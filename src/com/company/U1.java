package com.company;

public class U1 extends Rocket {

    public U1() {
        cost = 100;
        weightEmpty = 10000;
        weightCurrent = weightEmpty;
        maxWeight = 18000;
        launchFailChancePercentage = 5;
        landFailChancePercentage = 1;
        cargoLimit = maxWeight - weightEmpty;
    }
}
