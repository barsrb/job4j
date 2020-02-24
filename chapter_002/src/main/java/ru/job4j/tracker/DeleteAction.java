package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String deleteID = input.askStr("Enter ID of delete Item: ");
        if (tracker.delete(deleteID)) {
            System.out.println("Item delete successful.");
        } else {
            System.out.println("Item delete failed.");
        }
        return true;
    }
}
