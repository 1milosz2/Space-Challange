package com.test;

import com.company.Item;
import com.company.Rocket;
import org.junit.Assert;

class RocketTest {

    @org.junit.jupiter.api.Test
    void canCarryReturnsTrueWhenWeightOfItemDoesNotExceedCargoLimit() {
        Rocket r = new Rocket(100,12000,18000);
        Item cannon = new Item("cannon",5000);
        Item tank = new Item("tank",11000);
        Assert.assertTrue("Cannon's weight does not exceed cargo limit",r.canCarry(cannon));
        Assert.assertFalse("Tanks weight exceeds cargo limit",r.canCarry(tank));
    }

    @org.junit.jupiter.api.Test
    void carryUpdatesCurrentWeightWhenItemIsAdded() {
        Rocket r = new Rocket(12,10,20);
        Item cannon = new Item("cannon",5);
        r.carry(cannon);
        Assert.assertEquals("Total weight with cannon should equal to 15", 15, r.getWeightCurrent());
    }

    @org.junit.jupiter.api.Test
    void launchReturnsTrueWithDesignedProbability() {
        Rocket r = new Rocket(12,10,20);
        Item teslaCar = new Item("tesla Car",10);
        r.carry(teslaCar);
        r.setLaunchFailChancePercentage(100);
        Assert.assertFalse(r.launch());
        r.setLaunchFailChancePercentage(0);
        Assert.assertTrue(r.launch());
    }
}