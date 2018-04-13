package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int budget;

        Phase1 p1 = new Phase1();

        ArrayList<Item> ItemsPh1 = p1.loadItems();
        ArrayList<Rocket> U1P1 = p1.loadU1(ItemsPh1);
        ArrayList<Rocket> U2P1 = p1.loadU2(ItemsPh1);

        budget = p1.runSimulation(U1P1);
        System.out.println("First phase u1s cost is " + budget + "mln USD");

        budget = p1.runSimulation(U2P1);
        System.out.println("First phase u2s cost is " + budget + "mln USD");

        Phase2 p2 = new Phase2();

        ArrayList<Item> ItemsPh2 = p2.loadItems();
        ArrayList<Rocket> U1P2 = p2.loadU1(ItemsPh2);
        ArrayList<Rocket> U2P2 = p2.loadU2(ItemsPh2);

        budget = p1.runSimulation(U1P2);
        System.out.println("Second phase u1s cost is " + budget + "mln USD");

        budget = p1.runSimulation(U2P2);
        System.out.println("Second phase u2s cost is " + budget + "mln USD");

    }
}
