package ru.job4j.condition;

public class SqMax {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;

        if (first > result) {
            result = first;
        }

        if (second > result) {
            result = second;
        }

        if (third > result) {
            result = third;
        }
        return result;
    }
}