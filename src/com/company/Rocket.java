package com.company;

public class Rocket implements SpaceShip {

    private int cost;
    private int weightEmpty;
    private int weightCurrent;
    private int maxWeight;

    public Rocket (int costMillion, int weightEmpty, int maxWeight) {
        this.cost = costMillion;
        this.weightEmpty = weightEmpty;
        this.weightCurrent = weightEmpty;
        this.maxWeight = maxWeight;
    }

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    public final boolean canCarry(Item item) {
        if (weightCurrent + item.getWeight() <=maxWeight){
            return true;
        }
        else return false;
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
}
