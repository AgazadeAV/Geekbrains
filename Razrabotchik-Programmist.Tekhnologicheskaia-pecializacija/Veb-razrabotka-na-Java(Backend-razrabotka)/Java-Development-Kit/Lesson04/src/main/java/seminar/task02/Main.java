package seminar.task02;

/*
В рамках выполнения задачи необходимо:
Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
Получите уникальный список Set на основании List
Определите наименьший элемент (алфавитный порядок)
Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
Удалите все элементы содержащие букву ‘A’
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Анастасия",
                "Алексей",
                "Сергей",
                "Владимир",
                "Анастасия",
                "Елизавета",
                "Александра",
                "Сергей",
                "Владимир",
                "Анастасия"));

        // Получаем уникальный список
        Set<String> uniqueNames = new HashSet<>(names);
        System.out.println(uniqueNames);

        // Определяем наименьший элемент (алфавитный порядок)
        String minName = Collections.min(uniqueNames);
        System.out.println("Наименьший элемент (алфавитный порядок): " + minName);

        // Определяем наибольший элемент (по количеству букв в слове, но в обратном порядке)
        String maxName = Collections.max(uniqueNames, (a, b) -> Integer.compare(b.length(), a.length()));
        System.out.println("Наибольший элемент (по количеству букв в слове): " + maxName);

        // Удаляем все элементы, содержащие букву 'A'
        uniqueNames.removeIf(name -> name.contains("А") || name.contains("а"));
        System.out.println("Итоговый список после удаления имен с 'A': " + uniqueNames);
    }
}
