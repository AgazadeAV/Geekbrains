/*Задание №1
Заполнить список десятью случайными числами.
Отсортировать список методом sort() и вывести его на
экран. */

package Seminari.Seminar03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        int n = 25;
        int min = 1;
        int max = 101;
        Random random = new Random();
        ArrayList<Integer> list = fillList(min, max, n, random);
        System.out.println("List before sorting: " + list);
        Collections.sort(list);
        System.out.println("List after sorting: " + list);
    }

    private static ArrayList<Integer> fillList(int min, int max, int n, Random random) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100)); // случайные числа от 0 до 99
        }
        return list;
    }


}
