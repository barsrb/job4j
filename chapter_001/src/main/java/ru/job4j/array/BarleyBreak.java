package ru.job4j.array;

public class BarleyBreak {
    public static void main(String[] args) {
        int[][] table = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                table[row][col] = row * 3 + col + 1;
            }
        }
    }
}
