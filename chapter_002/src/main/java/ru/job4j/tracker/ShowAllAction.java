package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> items = tracker.findAll();
        System.out.println("Items in tracker - " + items.size());
        for (Item item : items) {
            System.out.println("Item ID - " + item.getId() + ", name - " + item.getName());
        }
        return true;
    }
}
