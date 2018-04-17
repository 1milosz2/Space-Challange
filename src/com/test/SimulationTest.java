package com.test;

import com.company.*;
import org.junit.Assert;

import java.io.File;
import java.util.List;

class SimulationTest {

    @org.junit.jupiter.api.Test
    void loadItemsReadsItemListFromFileAndReturnsItAsAnArrayList() {
        Simulation s = new Simulation();
        File phase1 = new File("phase-1.txt");
        Item item;
        List<Item> ItemsList = s.loadItems(phase1);
        item = ItemsList.get(ItemsList.size() - 1);
        Assert.assertEquals(item.getWeight(), 5000);
        Assert.assertEquals("water", item.getItemType());
    }

    @org.junit.jupiter.api.Test
    void calculatesU1FleetBudgetWhenPhase1FileGiven() {
        Simulation s = new Simulation();
        File phase1 = new File("phase-1.txt");
        List<Item> ItemsList = s.loadItems(phase1);
        List<Rocket> U1List = s.loadFleet(FleetType.U1, ItemsList);
        int budgetRequired = s.calculateBudgetRequired(U1List);
        boolean isBudgetPositiveNumber;
        isBudgetPositiveNumber = budgetRequired >= 0;
        Assert.assertTrue("Budget should be a positive number", isBudgetPositiveNumber);
    }

    @org.junit.jupiter.api.Test
    void calculatesU2FleetBudgetWhenPhase2FileGiven() {
        Simulation s = new Simulation();
        File phase1 = new File("phase-2.txt");
        List<Item> ItemsList = s.loadItems(phase1);
        List<Rocket> U2List = s.loadFleet(FleetType.U2, ItemsList);
        int budgetRequired = s.calculateBudgetRequired(U2List);
        boolean isBudgetPositiveNumber;
        isBudgetPositiveNumber = budgetRequired >= 0;
        Assert.assertTrue("Budget should be a positive number", isBudgetPositiveNumber);
    }
}