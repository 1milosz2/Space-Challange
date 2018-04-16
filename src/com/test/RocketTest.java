package com.test;

import com.company.Item;
import com.company.U1;
import com.company.U2;
import org.junit.Assert;

class RocketTest {

    @org.junit.jupiter.api.Test
    void canCarryReturnsTrueWhenWeightOfItemDoesNotExceedCargoLimit() {
        U1 u1 = new U1();
        Item cannon = new Item("cannon",5000);
        Item tank = new Item("tank",11000);
        Assert.assertTrue("Cannon's weight does not exceed cargo limit",u1.canCarry(cannon));
        Assert.assertFalse("Tanks weight exceeds cargo limit",u1.canCarry(tank));
    }

    @org.junit.jupiter.api.Test
    void carryUpdatesCurrentWeightWhenItemIsAdded() {
        U2 u2 = new U2();
        Item cannon = new Item("cannon",5000);
        u2.carry(cannon);
        Assert.assertEquals("Total weight with cannon should equal to 23000", 23000, u2.getWeightCurrent());
    }
}