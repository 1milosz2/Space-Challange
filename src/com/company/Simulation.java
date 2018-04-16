package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private Scanner scanner;
    private String phase;
    private String fleetType;

    public ArrayList<Item> loadItems(File phase){
        try {
            scanner = new Scanner(phase).useDelimiter("[=\\n]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Item> ItemsList = new ArrayList<>();
        while (scanner.hasNext()) {
            Item item = new Item(scanner.next(), scanner.nextInt());
            ItemsList.add(item);
        }
        scanner.close();
        return ItemsList;
    }

    public ArrayList<Rocket> loadFleet(String type, ArrayList<Item> ItemsList){
        int i = 0;
        ArrayList<Rocket> Rockets = new ArrayList<>();

        switch (type) {
            case "u1":
                while (i <= (ItemsList.size() - 1)) {
                    U1 u1 = new U1();
                    while ((i <= ItemsList.size() - 1) && u1.canCarry(ItemsList.get(i))) {
                        u1.carry(ItemsList.get(i));
                        i++;
                    }
                    Rockets.add(u1);
                }
            case "u2":
                while (i<=(ItemsList.size()-1)) {
                    U2 u2 = new U2();
                    while ((i<=ItemsList.size()-1) && u2.canCarry(ItemsList.get(i))) {
                        u2.carry(ItemsList.get(i));
                        i++;
                    }
                    Rockets.add(u2);
                }
        }
        return Rockets;
    }

    public int calculateBudgetRequired(ArrayList<Rocket> RocketList){
        int budgetNeeded = 0;
        for (Rocket r : RocketList) {
            budgetNeeded += r.getCost();
            while (!(r.launch() && r.land()))
            budgetNeeded += r.getCost();
        }
        return budgetNeeded;
    }

    public void communicateOutcome(int budget) {
        System.out.println(phase + " fleet of " + fleetType + " cost is " + budget + "mln USD");
    }

    public void runSimulation (File itemsList,String fleetType) {
        this.phase = itemsList.getName().substring(0,itemsList.getName().length()-4);
        this.fleetType = fleetType;
        ArrayList<Item> items = loadItems(itemsList);
        ArrayList<Rocket> fleet = loadFleet(fleetType,items);
        int cost = calculateBudgetRequired(fleet);
        communicateOutcome(cost);
        }
}
