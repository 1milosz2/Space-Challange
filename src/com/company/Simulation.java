package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Simulation {

    public abstract ArrayList<Item> loadItems();

    public ArrayList<Rocket> loadU1(ArrayList<Item> ItemsList){
        int i = 0;
        ArrayList<Rocket> U1Rockets = new ArrayList<>();

        while (i<=(ItemsList.size()-1)) {
            U1 u1 = new U1(100,10000,18000,5,1);
            while ((i<=ItemsList.size()-1) && u1.canCarry(ItemsList.get(i))) {
                u1.carry(ItemsList.get(i));
                i++;
            }
            U1Rockets.add(u1);
        }
        return U1Rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> ItemsList){
        int i = 0;
        ArrayList<Rocket> U2Rockets = new ArrayList<>();

        while (i<=(ItemsList.size()-1)) {
            U2 u2 = new U2(120,18000,29000,4,8);
            while ((i<=ItemsList.size()-1) && u2.canCarry(ItemsList.get(i))) {
                u2.carry(ItemsList.get(i));
                i++;
            }
            U2Rockets.add(u2);
        }
        return U2Rockets;
    }

    public int runSimulation (ArrayList<Rocket> RocketList){
        int budgetNeeded = 0;
        for (int i = 0; i < RocketList.size()-1 ; i++) {
            budgetNeeded += RocketList.get(i).getCost();
            while (!(RocketList.get(i).launch() && RocketList.get(i).land()))
            budgetNeeded += RocketList.get(i).getCost();
        }
        return budgetNeeded;
    }
}
