package com.test;

import com.company.Item;
import com.company.Rocket;
import com.company.Simulation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimulationTest {

    @Test
    public void loadItemsPhase1() {
        Simulation s = new Simulation();
        ArrayList<Item> ItemsList = s.loadItemsPhase1();
        Assert.assertNotNull("array should consist of items objects",ItemsList);
    }

    @Test
    public void loadU1() {
        Simulation s = new Simulation();
        ArrayList<Item> ItemsList = s.loadItemsPhase1();
        ArrayList<Rocket> U1List = s.loadU1(ItemsList);
        Assert.assertNotNull("array should consist of items objects",U1List);
    }

    @Test
    public void runSimulation() {
        Simulation s = new Simulation();
        ArrayList<Item> ItemsList = s.loadItemsPhase1();
        ArrayList<Rocket> U1List = s.loadU1(ItemsList);
        int budegetRequired = s.runSimulation(U1List);
        boolean isBudgetZero = 0 == budegetRequired;
        Assert.assertFalse("Budget shouldn't be 0", isBudgetZero);
    }
}