/*Задание №0
Создать структуру для хранения Номеров паспортов и Фамилий
сотрудников организации.
123456 Иванов
321456 Васильев
234561 Петрова
234432 Иванов
654321 Петрова
345678 Иванов
Вывести данные по сотрудникам с фамилией Иванов. */

package Seminari.Seminar05;

import java.util.HashMap;
import java.util.Map;

public class Task00 {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<>();

        db.put(123456, "Ivanov");
        db.put(321456, "Vasilev");
        db.put(234561, "Petrova");
        db.put(234432, "Ivanov");
        db.put(654321, "Petrova");
        db.put(345678, "Ivanov");

        String targetName = "Ivanov";

        printIvanov(db, targetName);
    }

    public static void printIvanov(Map<Integer, String> db, String targetName) {
        for (var item : db.entrySet()) {
            if (item.getValue().equals(targetName)) {
                System.out.printf("[%d : %s]\n", item.getKey(), item.getValue());
            }
        }
    }
}
