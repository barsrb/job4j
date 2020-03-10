package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        Map<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenThreeOrders() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order("3sfe", "Dress");
        Order order2 = new Order("2dsa", "Pants");
        Order order3 = new Order("4442", "Sweeter");
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        Map<String, Order> map = OrderConvert.process(orders);
        Map<String, Order> expect = new HashMap<>();
        expect.put(order1.getNumber(), order1);
        expect.put(order2.getNumber(), order2);
        expect.put(order3.getNumber(), order3);
        assertThat(map, is(expect));
    }

    @Test
    public void whenZeroOrder() {
        List<Order> orders = new ArrayList<>();
        Map<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(0));
    }
}