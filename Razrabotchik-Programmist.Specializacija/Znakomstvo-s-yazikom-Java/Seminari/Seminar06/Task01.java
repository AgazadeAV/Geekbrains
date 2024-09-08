/*Задание №1
1. Напишите метод, который заполнит массив из 1000 элементов случайными
цифрами от 0 до 24.
2. Создайте метод, в который передайте заполненный выше массив и с
помощью Set вычислите процент уникальных значений в данном массиве и
верните его в виде числа с плавающей запятой.
Для вычисления процента используйте формулу:
процент уникальных чисел = количество уникальных чисел * 100 / общее
количество чисел в массиве. */

package Seminari.Seminar06;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task01 {

    public static int[] fillArrayWithRandomNumbers(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    public static double calculateUniquePercentage(int[] array) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : array) {
            uniqueNumbers.add(num);
        }
        return (double) uniqueNumbers.size() * 100 / array.length;
    }

    public static void main(String[] args) {
        int size = 1000;
        int bound = 501;

        int[] randomArray = fillArrayWithRandomNumbers(size, bound);
        double uniquePercentage = calculateUniquePercentage(randomArray);
        System.out.println("Percentage of unique values: " + uniquePercentage + "%");
    }

}