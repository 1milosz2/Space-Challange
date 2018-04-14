package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int budget;
        File p1Items = new File("phase-1.txt");

        Simulation p1 = new Simulation();

        ArrayList<Item> ItemsPh1 = p1.loadItems(p1Items);
        ArrayList<Rocket> U1P1 = p1.loadFleet("u1",ItemsPh1);
        ArrayList<Rocket> U2P1 = p1.loadFleet("u2",ItemsPh1);

        budget = p1.runSimulation(U1P1);
        System.out.println("First phase u1s cost is " + budget + "mln USD");

        budget = p1.runSimulation(U2P1);
        System.out.println("First phase u2s cost is " + budget + "mln USD");
    }
}
