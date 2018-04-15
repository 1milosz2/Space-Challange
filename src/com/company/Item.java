package com.company;

public class Item {

    private int weight;
    private String type;

    public Item(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getItemType() {
        return type;
    }


}
