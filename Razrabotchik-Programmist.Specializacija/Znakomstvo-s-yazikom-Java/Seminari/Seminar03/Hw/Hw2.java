package Seminari.Seminar03.Hw;

import java.util.ArrayList;

public class Hw2 {

    public static void removeEvenNumbers(Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (Integer elem : arr) {
            if (elem % 2 != 0) {
                list.add(elem);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        removeEvenNumbers(array);
    }
}
