package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.print("Enter ID of edited Item: ");
                String editedID = scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if(tracker.replace(editedID, item)) {
                    System.out.println("Item edit successful.");
                } else {
                    System.out.println("Item edit failed.");
                };
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.print("Enter ID of delete Item: ");
                String deleteID = scanner.nextLine();
                if (tracker.delete(deleteID)) {
                    System.out.println("Item delete successful.");
                } else {
                    System.out.println("Item delete failed.");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by ID ====");
                System.out.print("Enter ID: ");
                String itemID = scanner.nextLine();
                Item item = tracker.findById(itemID);
                if (item != null) {
                    System.out.println("Item found. Name - " + item.getName());
                } else {
                    System.out.println("Item was not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Find Items by name ====");
                System.out.print("Enter name: ");
                String itemName = scanner.nextLine();
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
        System.out.print("Select:");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}