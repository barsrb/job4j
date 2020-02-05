package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int first_max = first>second ? first : second;
        int second_max = third>first_max ? third : first_max;
        return second_max;
    }
}
