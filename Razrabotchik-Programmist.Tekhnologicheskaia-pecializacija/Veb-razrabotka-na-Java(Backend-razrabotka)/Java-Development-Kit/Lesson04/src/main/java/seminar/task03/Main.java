package seminar.task03;

/*
В рамках выполнения задачи необходимо:
Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
Найдите человека с самым маленьким номером телефона
Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("123456789", "Алексей");
        phoneBook.put("98765432", "Сергей");
        phoneBook.put("5555555", "Анастасия");
        phoneBook.put("321654", "Владимир");

        System.out.println(findByMinPhoneNumber(phoneBook));
        System.out.println(findByMaxAlphabetName(phoneBook));
    }

    public static String findByMinPhoneNumber(Map<String, String> phoneBook) {
        Set<Long> numbers = phoneBook.keySet().stream().map(Long::valueOf).collect(Collectors.toSet());
        long number = numbers.stream().min(Comparator.naturalOrder()).get();
        return String.format("Наименьший номер: %s, владелец: %s",
                number, phoneBook.get(String.valueOf(number)));
    }

    public static String findByMaxAlphabetName(Map<String, String> phoneBook) {
        Set<Map.Entry<String, String>> elements = phoneBook.entrySet();
        Map.Entry<String, String> name = elements.stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        return String.format("Наибольшее имя в алфавитном порядке: %s, номер телефона: %s",
                name.getValue(), name.getKey());
    }
}
