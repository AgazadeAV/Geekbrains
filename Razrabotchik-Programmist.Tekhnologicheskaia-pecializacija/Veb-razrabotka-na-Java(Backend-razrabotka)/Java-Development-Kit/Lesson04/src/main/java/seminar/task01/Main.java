package seminar.task01;

/*
В рамках выполнения задачи необходимо:
Создайте коллекцию мужских и женских имен с помощью интерфейса List
Отсортируйте коллекцию в алфавитном порядке
Отсортируйте коллекцию по количеству букв в слове
Разверните коллекцию
 */

import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Алексей",
                "Сергей",
                "Владимир",
                "Анастасия",
                "Елизавета",
                "Александра"));

        System.out.println("Изначальный список:");
        System.out.println(names);

        System.out.println("Сортировка по алфавитному порядку:");
        System.out.println(sortByAlphabet(names));

        System.out.println("Сортировка по количеству букв в слове:");
        System.out.println(sortByLength(names));

        System.out.println("Разворот коллекции:");
        System.out.println(reverseList(names));
    }

    public static List<String> sortByAlphabet(List<String> names) {
        List<String> sortedList = new ArrayList<>(names);
        sortedList.sort(String::compareTo);
        return sortedList;
    }

    public static List<String> sortByLength(List<String> names) {
        List<String> sortedList = new ArrayList<>(names);
        sortedList.sort(Comparator.comparingInt(String::length));
        return sortedList;
    }

    public static List<String> reverseList(List<String> names) {
        List<String> reversedList = new ArrayList<>(names);
        Collections.reverse(reversedList);
        return reversedList;
    }
}
