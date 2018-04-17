package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File Phase1 = new File("phase-1.txt");
        Simulation s = new Simulation();

        s.runSimulation(Phase1, FleetType.U1);
        s.runSimulation(Phase1, FleetType.U2);

        File Phase2 = new File("phase-2.txt");

        s.runSimulation(Phase2, FleetType.U1);
        s.runSimulation(Phase2, FleetType.U2);
    }
}
