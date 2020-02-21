package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];

    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] tempResults = new Item[100];
        int count = 0;
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                tempResults[count++] = items[index];
            }
        }
        return Arrays.copyOf(tempResults, count);
    }

    public Item findById(String id) {
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                return  items[index];
            }
        }
        return null;
    }


}
