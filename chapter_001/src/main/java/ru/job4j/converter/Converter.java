package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static  int euroToRuble(int value) {
        return value * 70;
    }

    public static  int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int ruble = 420;
        int euro = rubleToEuro(ruble);
        System.out.println(ruble + " rubles are " + euro + " euro.");
        int dollar = rubleToDollar(ruble);
        System.out.println(ruble + " rubles are " + dollar + " euro.");
        euro = 10;
        ruble = euroToRuble(euro);
        System.out.println(euro + " euro are " + ruble + " ruble.");
        dollar = 20;
        ruble = dollarToRuble(dollar);
        System.out.println(dollar + " dollar are " + ruble + " ruble.");
    }
}