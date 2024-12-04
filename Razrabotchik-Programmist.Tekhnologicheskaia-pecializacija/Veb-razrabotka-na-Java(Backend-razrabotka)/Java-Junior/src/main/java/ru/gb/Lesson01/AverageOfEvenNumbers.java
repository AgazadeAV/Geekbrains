package ru.gb.Lesson01;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageOfEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        OptionalDouble average = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .average();

        if (average.isPresent()) {
            System.out.println("Среднее значение четных чисел: " + average.getAsDouble());
        } else {
            System.out.println("В списке нет четных чисел.");
        }
    }
}
