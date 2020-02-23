package ru.job4j.tracker;


public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select:");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item [] items= tracker.findAll();
                System.out.println("Items in tracker - " + items.length);
                for (int index = 0; index < items.length; index++) {
                    System.out.println("Item ID - " + items[index].getId() + ", name - " + items[index].getName());
                }
            } else if (select == 2){
                System.out.println("=== Edit Item ====");
                String editedID = input.askStr("Enter ID of edited Item: ");
                String name = input.askStr("Enter new name: ");
                Item item = new Item(name);
                if(tracker.replace(editedID, item)) {
                    System.out.println("Item edit successful.");
                } else {
                    System.out.println("Item edit failed.");
                };
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                String deleteID = input.askStr("Enter ID of delete Item: ");
                if (tracker.delete(deleteID)) {
                    System.out.println("Item delete successful.");
                } else {
                    System.out.println("Item delete failed.");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by ID ====");
                String itemID = input.askStr("Enter ID: ");
                Item item = tracker.findById(itemID);
                if (item != null) {
                    System.out.println("Item found. Name - " + item.getName());
                } else {
                    System.out.println("Item was not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Find Items by name ====");
                String itemName = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(itemName);
                System.out.println("Founded items - " + items.length);
                for (int index = 0; index < items.length; index++) {
                    System.out.println("Item ID - " + items[index].getId() + ", name - " + items[index].getName());
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}