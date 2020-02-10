package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 1;
        double remains = amount*((100+percent)/100);
        while (remains>salary){
            remains = (remains-salary)*((100+percent)/100);
            year++;
        }
        return year;
    }
}