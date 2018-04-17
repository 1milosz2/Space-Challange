package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    private Scanner scanner;
    private String phase;
    private String fleetType;

    public List<Item> loadItems(File phase) {
        try {
            scanner = new Scanner(phase).useDelimiter("[=\\n]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Item> itemsList = new ArrayList<>();
        while (scanner.hasNext()) {
            Item item = new Item(scanner.next(), scanner.nextInt());
            itemsList.add(item);
        }
        scanner.close();
        return itemsList;
    }

    public List<Rocket> loadFleet(FleetType type, List<Item> items) {
        int i = 0;
        ArrayList<Rocket> rockets = new ArrayList<>();
        while (i <= (items.size() - 1)) {
            Rocket r = createNewRocket(type);
            while ((i <= items.size() - 1) && r.canCarry(items.get(i))) {
                r.carry(items.get(i));
                i++;
            }
            rockets.add(r);
        }
        return rockets;
    }

    private Rocket createNewRocket(FleetType type) {
        switch (type) {
            case U1:
                return new U1();
            case U2:
                return new U2();
            default:
                return new Rocket();
        }
    }

    public int calculateBudgetRequired(List<Rocket> RocketList) {
        int budgetNeeded = 0;
        for (Rocket r : RocketList) {
            budgetNeeded += r.getCost();
            while (!(r.launch() && r.land()))
                budgetNeeded += r.getCost();
        }
        return budgetNeeded;
    }

    private void communicateOutcome(int budget) {
        System.out.println(phase + " fleet of " + fleetType + " cost is " + budget + "mln USD");
    }

    public void runSimulation(File itemsList, FleetType fleetType) {
        this.phase = itemsList.getName().substring(0, itemsList.getName().length() - 4);
        this.fleetType = fleetType.toString();
        List<Item> items = loadItems(itemsList);
        List<Rocket> fleet = loadFleet(fleetType, items);
        int cost = calculateBudgetRequired(fleet);
        communicateOutcome(cost);
    }
}
