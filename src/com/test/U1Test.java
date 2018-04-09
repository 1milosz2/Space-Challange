package com.test;

import com.company.Item;
import com.company.U1;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class U1Test {

    @Test
    public void land() {
        U1 fail = new U1(12,10,18,10,100);
        U1 success = new U1(12,10,18,10,100);
        Item bottleOfWatter = new Item("bottle of water", 8);
        fail.carry(bottleOfWatter);
        Assert.assertFalse("Should crash",fail.land());
        Assert.assertTrue("Should succeed", success.land());
    }

    @Test
    public void launch() {
        U1 fail = new U1(12,10,18,10,100);
        U1 success = new U1(12,10,18,10,100);
        Item bottleOfWatter = new Item("bottle of water", 8);
        fail.carry(bottleOfWatter);
        Assert.assertFalse("Should crash",fail.land());
        Assert.assertTrue("Should succeed", success.land());
    }
}