package com.company;

public class U1 extends Rocket {

    public U1() {
        setCost(100);
        setWeightEmpty(10000);
        setWeightCurrent(10000);
        setMaxWeight(18000);
        setLaunchFailChancePercentage(5);
        setLandFailChancePercentage(1);
        setCargoLimit(getMaxWeight() - getWeightEmpty());
    }
}
