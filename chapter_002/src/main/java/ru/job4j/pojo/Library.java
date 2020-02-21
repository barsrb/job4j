package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cc = new Book("Clean code", 800);
        Book jcr = new Book("Java. The Complete Reference", 1488);
        Book dp = new Book("Design Patterns", 368);
        Book sco = new Book("Structured Computer Organization", 816);

        Book[] books = new Book[4];
        books[0] = cc;
        books[1] = jcr;
        books[2] = dp;
        books[3] = sco;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " with " + books[i].getPages() + " pages.");
        }

        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " with " + books[i].getPages() + " pages.");
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals("Clean code")) {
                System.out.println(books[i].getTitle() + " book found.");
            }
        }


    }
}
