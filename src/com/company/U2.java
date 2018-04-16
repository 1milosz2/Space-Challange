package com.company;

public class U2 extends Rocket {

   public U2() {
        setCost(120);
        setWeightEmpty(18000);
        setWeightCurrent(18000);
        setMaxWeight(29000);
        setCargoLimit(getMaxWeight() - getWeightEmpty());
        setLaunchFailChancePercentage(4);
        setLandFailChancePercentage(8);
    }
}
