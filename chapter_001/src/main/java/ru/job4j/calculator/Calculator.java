package ru.job4j.calculator;

/**
 * Calculator - класс для простых вычислений из задания 3.3
 * @author Mikhail Pershukov
 * @since 30.01.2020
 */
public class Calculator {

    /**
     * Метод сложения. Выводит на экран сумму.
     * @param first первое слогаемое
     * @param second второе слогаемое
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);

    }

    /**
     * Метод деления. Выводит на экран частное.
     * @param first делимое
     * @param second делитель
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);

    }

    /**
     * Метод умножения. Выводит на экран произведение.
     * @param first первый множитель
     * @param second второй множитель
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);

    }


    /**
     * Метод вычитания. Выводит на экран разности.
     * @param first уменьшаемое
     * @param second вычитаемое
     */
    public static void subtrack(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);

    }

    /**
     * Точка входа в программу. Метод для тестирования класса.
     * @param args - агрументы
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}
