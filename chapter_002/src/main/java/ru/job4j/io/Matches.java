package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matches = 11;
        int currentPlayer = 1;
        System.out.println("На столе " + matches + " спичек.");
        while (matches>3){
            System.out.println("Игрок " + currentPlayer + ", бери от 1 до 3 спичек.");
            int getMatches = Integer.valueOf(scanner.nextLine());
            if (getMatches<=3 && getMatches>=1) {
                matches -= getMatches;
                currentPlayer = currentPlayer == 1 ? 2 : 1;
            } else {
                System.out.println("Вы ввели что-то не то. Попробуйте снова.");
            }
            System.out.println("На столе спичек - " + matches + ".");
        }
        System.out.println("Победил игрок " + currentPlayer);
    }
}
