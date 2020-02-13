package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                int point = index + 1;
                while (point < array.length) {
                    if (array[point] != null) {
                        array[index] = array[point];
                        array[point] = null;
                        break;
                    }
                    point++;
                }
            }
        }
        return array;
    }
}