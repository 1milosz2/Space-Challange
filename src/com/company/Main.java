package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int u1BudgetPh1;
        int u2BudgetPh1;
        int u1BudgetPh2;
        int u2BudgetPh2;

        Simulation s = new Simulation();
        ArrayList<Item> ItemsPh1;
        ArrayList<Item> ItemsPh2;
        ArrayList<Rocket> U1sPh1;
        ArrayList<Rocket> U2sPh1;
        ArrayList<Rocket> U1sPh2;
        ArrayList<Rocket> U2sPh2;

        ItemsPh1 = s.loadItemsPhase1();
        U1sPh1 = s.loadU1(ItemsPh1);
        U2sPh1 = s.loadU2(ItemsPh1);

        u1BudgetPh1= s.runSimulation(U1sPh1);
        u2BudgetPh1 = s.runSimulation(U2sPh1);

        System.out.println("First phase u1s cost is " + u1BudgetPh1 + "mln USD");
        System.out.println("First phase u2s cost is " + u2BudgetPh1 + "mln USD");

        ItemsPh2 = s.loadItemsPhase2();
        U1sPh2 = s.loadU1(ItemsPh2);
        U2sPh2 = s.loadU2(ItemsPh2);

        u1BudgetPh2= s.runSimulation(U1sPh2);
        u2BudgetPh2 = s.runSimulation(U2sPh2);

        System.out.println("Second phase u1s cost is " + u1BudgetPh2 + "mln USD");
        System.out.println("Second phase u2s cost is " + u2BudgetPh2 + "mln USD");

    }
}
