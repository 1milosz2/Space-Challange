package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    int u1Budget;
    int u2Budget;

    Simulation s = new Simulation();
    ArrayList<Item> Items;
    ArrayList<Rocket> U1s;
    ArrayList<Rocket> U2s;


    Items = s.loadItems();
    U1s = s.loadU1(Items);
    U2s = s.loadU2(Items);

    u1Budget= s.runSimulation(U1s);
    u2Budget = s.runSimulation(U2s);
        System.out.println("Koszt dla u1 to " + u1Budget);
        System.out.println("Koszt dla u2 to " + u2Budget);
    }
}
