package ru.job4j.array;

public class SortSelected {
    public static int[] sort(int[] data){
        for(int index = 0; index < data.length; index++){
            int min = MinDiapason.findMin(data, index, data.length-1);
            int index_of_min = FindLoop.indexOf(data, min, index, data.length);
            data = SwitchArray.swap(data, index, index_of_min);
        }
        return  data;
    }
}
