package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(itemName);
        System.out.println("Founded items - " + items.length);
        for (int index = 0; index < items.length; index++) {
            System.out.println("Item ID - " + items[index].getId() + ", name - " + items[index].getName());
        }
        return true;
    }
}
