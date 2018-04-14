package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int budget;
        File Phase1 = new File("phase-1.txt");
        Simulation s = new Simulation();

        ArrayList<Item> Items = s.loadItems(Phase1);
        ArrayList<Rocket> U1 = s.loadFleet("u1",Items);

        budget = s.runSimulation(U1);
        s.communicateOutcome(budget);

        ArrayList<Rocket> U2 = s.loadFleet("u2",Items);

        budget = s.runSimulation(U2);
        s.communicateOutcome(budget);

        File Phase2 = new File("phase-2.txt");
        Items = s.loadItems(Phase2);

        U1 = s.loadFleet("u1",Items);
        budget = s.runSimulation(U1);
        s.communicateOutcome(budget);

        U2 = s.loadFleet("u2",Items);
        budget = s.runSimulation(U2);
        s.communicateOutcome(budget);
    }
}
