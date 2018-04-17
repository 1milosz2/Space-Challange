package com.company;

import java.util.Random;

public class Rocket implements SpaceShip {

    protected int cost;
    protected int weightEmpty;
    protected int weightCurrent;
    protected int maxWeight;
    protected double launchFailChancePercentage;
    protected double landFailChancePercentage;
    protected int cargoLimit = maxWeight - weightEmpty;

    Rocket() {}

    public boolean launch(){
        int random = new Random().nextInt(100);
        double chanceCalculation = getLaunchFailChancePercentage() * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
        return random >= chanceCalculation;
    }

    public boolean land(){
        int random = new Random().nextInt(100);
        double chanceCalculation = getLandFailChancePercentage() * ((getWeightCurrent() - getWeightEmpty()) / cargoLimit);
        return random >= chanceCalculation;
    }

    public final boolean canCarry(Item item) {
        return weightCurrent + item.getWeight() <= maxWeight;
    }

    public final void carry(Item item){
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

    public int getMaxWeight() {
        return maxWeight;
    }

    public double getLaunchFailChancePercentage() {
        return launchFailChancePercentage;
    }

    public double getLandFailChancePercentage() {
        return landFailChancePercentage;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeightEmpty(int weightEmpty) {
        this.weightEmpty = weightEmpty;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setLaunchFailChancePercentage(double launchFailChancePercentage) {
        this.launchFailChancePercentage = launchFailChancePercentage;
    }

    public void setCargoLimit(int cargoLimit) {
        this.cargoLimit = cargoLimit;
    }

    public void setLandFailChancePercentage(double landFailChancePercentage) {
        this.landFailChancePercentage = landFailChancePercentage;
    }

    public void setWeightCurrent(int weightCurrent) {
        this.weightCurrent = weightCurrent;
    }
}
