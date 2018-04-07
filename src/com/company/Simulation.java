package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private File phase1 = new File("phase-1.txt");
//    private File phase2 = new File("phase-2.txt");
    private Scanner scanner1;

    {
        try {
            scanner1 = new Scanner(phase1).useDelimiter("=|\\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    private Scanner scanner2;

//    {
//        try {
//            scanner2 = new Scanner(phase2).useDelimiter("=");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


    public ArrayList<Item> loadItems() {
        ArrayList<Item> ItemsList = new ArrayList<Item>();
        while (scanner1.hasNextLine()) {
            Item item = new Item(scanner1.next(),scanner1 .nextInt());//
            ItemsList.add(item);
           }
//        while (scanner2.hasNextLine()) {
//            Item item = new Item(scanner2.next(),scanner2 .nextInt());//
//            ItemsList.add(item);
//        }
        return ItemsList;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> ItemsList){
        int i = 0;
        ArrayList<Rocket> U1Rockets = new ArrayList<Rocket>();

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
        ArrayList<Rocket> U2Rockets = new ArrayList<Rocket>();

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

        for (int j = 0; j < RocketList.size()-1 ; j++) {
            budgetNeeded += RocketList.get(j).getCost();
            while (!(RocketList.get(j).launch() & RocketList.get(j).land()))
            budgetNeeded += RocketList.get(j).getCost();
        }
        return budgetNeeded;
    }
}
