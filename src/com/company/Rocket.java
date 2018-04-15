package com.company;

import java.util.Random;

public class Rocket implements SpaceShip {

    private int cost;
    private int weightEmpty;
    private int weightCurrent;
    private int maxWeight;
    private double launchFailChancePercentage;
    private double landFailChancePercentage;
    private int cargoLimit = getMaxWeight() - getWeightEmpty();

    public Rocket(int cost, int weightEmpty, int maxWeight) {
        this.cost = cost;
        this.weightEmpty = weightEmpty;
        this.weightCurrent = weightEmpty;
        this.maxWeight = maxWeight;
        this.cargoLimit = maxWeight - weightCurrent;
    }

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

    int getWeightEmpty() {
        return weightEmpty;
    }

    int getMaxWeight() {
        return maxWeight;
    }

    private double getLaunchFailChancePercentage() {
        return launchFailChancePercentage;
    }

    private double getLandFailChancePercentage() {
        return landFailChancePercentage;
    }

    void setCost(int cost) {
        this.cost = cost;
    }

    void setWeightEmpty(int weightEmpty) {
        this.weightEmpty = weightEmpty;
    }

    void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setLaunchFailChancePercentage(double launchFailChancePercentage) {
        this.launchFailChancePercentage = launchFailChancePercentage;
    }

    void setCargoLimit(int cargoLimit) {
        this.cargoLimit = cargoLimit;
    }

    void setLandFailChancePercentage(double landFailChancePercentage) {
        this.landFailChancePercentage = landFailChancePercentage;


    }
}
