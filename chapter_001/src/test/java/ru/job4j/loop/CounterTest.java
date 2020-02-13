package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public void sum0to10() {
        int sum = Counter.sum(0, 10);
        Assert.assertEquals(sum, 55);
    }

    @Test
    public void sum1to1() {
        int sum = Counter.sum(1, 1);
        Assert.assertEquals(sum, 1);
    }

    @Test
    public void sumNeg1to1() {
        int sum = Counter.sum(-1, 1);
        Assert.assertEquals(sum, 0);
    }
    @Test
    public void sumByEven0to10() {
        int sum = Counter.sumByEven(0, 10);
        Assert.assertEquals(sum, 30);
    }

    @Test
    public void sumByEven3To8() {
        int sum = Counter.sumByEven(3, 8);
        Assert.assertEquals(sum, 18);
    }

    @Test
    public void sumByEven1to1() {
        int sum = Counter.sumByEven(1, 1);
        Assert.assertEquals(sum, 0);
    }
}
