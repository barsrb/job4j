package ru.job4j.array;

public class Matrix {
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                table[row - 1][col - 1] = row * col;
            }
        }
        return table;
    }
}
