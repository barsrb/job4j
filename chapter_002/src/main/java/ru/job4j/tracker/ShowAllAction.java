package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        System.out.println("Items in tracker - " + items.length);
        for (int index = 0; index < items.length; index++) {
            System.out.println("Item ID - " + items[index].getId() + ", name - " + items[index].getName());
        }
        return true;
    }
}
