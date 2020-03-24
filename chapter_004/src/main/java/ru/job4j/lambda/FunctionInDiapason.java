package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInDiapason {
    static List<Double> diapason(int start, int end, Function<Double, Double> func){
        List<Double> result = new ArrayList<>();
        for (int val = start; val < end; val++){
            result.add(func.apply((double) val));
        }
        return result;
    }
}
