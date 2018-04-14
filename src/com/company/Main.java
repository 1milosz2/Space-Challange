package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int budget;
        File p1Items = new File("phase-1.txt");

        Simulation s = new Simulation();

        ArrayList<Item> Items = s.loadItems(p1Items);
        ArrayList<Rocket> U1 = s.loadFleet("u1",Items);
        ArrayList<Rocket> U2 = s.loadFleet("u2",Items);

        budget = s.runSimulation(U1);
        System.out.println("First phase u1s cost is " + budget + "mln USD");

        budget = s.runSimulation(U2);
        System.out.println("First phase u2s cost is " + budget + "mln USD");

        File p2Items = new File("phase-2.txt");

        Items = s.loadItems(p2Items);
        U1 = s.loadFleet("u1",Items);
        U2 = s.loadFleet("u2",Items);

        budget = s.runSimulation(U1);
        System.out.println("Second phase u1s cost is " + budget + "mln USD");

        budget = s.runSimulation(U2);
        System.out.println("Second phase u2s cost is " + budget + "mln USD");
    }
}
