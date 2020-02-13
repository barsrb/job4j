package ru.job4j.array;

public class MatrixCheck {
    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = true;
        for ( int col = 0; col < board[row].length; col++ ) {
            if ( board[row][col] !='X' ) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(char[][] board, int column) {
        boolean result = true;
        for ( int row = 0; row < board.length; row++ ) {
            if ( board[row][column] !='X' ) {
                result = false;
                break;
            }
        }
        return result;
    }
}