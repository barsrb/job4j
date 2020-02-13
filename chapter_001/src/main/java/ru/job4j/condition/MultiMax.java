package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int firstMax = first > second ? first : second;
        int secondMax = third > firstMax ? third : firstMax;
        return secondMax;
    }
}
