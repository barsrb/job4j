package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public void sum_0_10(){
        int sum = Counter.sum(0, 10);
        Assert.assertEquals(sum, 55);
    }

    @Test
    public void sum_1_1(){
        int sum = Counter.sum(1, 1);
        Assert.assertEquals(sum, 1);
    }

    @Test
    public void sum_neg1_1(){
        int sum = Counter.sum(-1, 1);
        Assert.assertEquals(sum, 0);
    }
    @Test
    public void sumByEven_0_10(){
        int sum = Counter.sumByEven(0, 10);
        Assert.assertEquals(sum, 30);
    }

    @Test
    public void sumByEven_3_8(){
        int sum = Counter.sumByEven(3, 8);
        Assert.assertEquals(sum, 18);
    }

    @Test
    public void sumByEven_1_1(){
        int sum = Counter.sumByEven(1, 1);
        Assert.assertEquals(sum, 0);
    }
}
