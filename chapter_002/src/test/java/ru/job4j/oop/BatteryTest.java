package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class BatteryTest {

    @Test
    public  void testExchange() {
        Battery batteryFrom = new Battery(50);
        Battery batteryTo = new Battery(10);
        batteryFrom.exchange(batteryTo);
        Assert.assertEquals(batteryTo.getLoad(), 60);
    }
}
