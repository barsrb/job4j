package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String editedID = input.askStr("Enter ID of edited Item: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(editedID, item)) {
            System.out.println("Item edit successful.");
        } else {
            System.out.println("Item edit failed.");
        }
        return true;
    }
}
