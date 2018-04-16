package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File Phase1 = new File("phase-1.txt");
        Simulation s = new Simulation();

        s.runSimulation(Phase1,"u1");
        s.runSimulation(Phase1,"u2");

        File Phase2 = new File("phase-2.txt");

        s.runSimulation(Phase2,"u1");
        s.runSimulation(Phase2,"u2");

    }
}
