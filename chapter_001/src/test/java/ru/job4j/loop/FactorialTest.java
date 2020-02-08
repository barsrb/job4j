package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {
    @Test
    public void factorial_0(){
        int result = Factorial.calc(0);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void factorial_1(){
        int result = Factorial.calc(1);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void factorial_5(){
        int result = Factorial.calc(5);
        Assert.assertEquals(result, 120);
    }
}
