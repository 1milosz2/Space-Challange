package com.company;

public class Item {

    private String type;
    private int weight;

    public Item(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
}
