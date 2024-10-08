package hw.seminar_homework;

import java.time.LocalDate;

/**
 * Класс Holiday содержит методы для работы с праздниками и поздравлениями сотрудников.
 */
public class Holiday {
    /**
     * Перечисление Celebration представляет возможные праздники.
     */
    public enum Celebration {
        NO_HOLIDAY,    // Нет праздника
        NEW_YEAR,      // Новый год
        MARCH_8,       // 8 марта
        FEBRUARY_23    // 23 февраля
    }

    /**
     * Метод поздравляет сотрудников в зависимости от текущего праздника.
     *
     * @param employees Массив сотрудников, которых нужно поздравить.
     */
    public static void greetEmployees(Employee[] employees) {
        LocalDate today = LocalDate.now(); // Текущая дата
        Celebration holiday = determineHoliday(today); // Определение праздника

        // Проверяем, есть ли праздник
        if (holiday == Celebration.NO_HOLIDAY) {
            System.out.println("Сегодня нет праздника, работаем (((");
            return; // Завершаем метод, так как праздника нет
        }

        // Поздравляем сотрудников
        for (Employee employee : employees) {
            switch (holiday) {
                case NEW_YEAR:
                    System.out.println("С Новым годом, " + employee.getName() + "!");
                    break;
                case MARCH_8:
                    if (employee.getGender() == Customer.Gender.FEMALE) {
                        System.out.println("С 8 марта, " + employee.getName() + "!");
                    }
                    break;
                case FEBRUARY_23:
                    if (employee.getGender() == Customer.Gender.MALE) {
                        System.out.println("С 23 февраля, " + employee.getName() + "!");
                    }
                    break;
            }
        }
    }

    /**
     * Метод определяет текущий праздник по дате.
     *
     * @param date Текущая дата.
     * @return Возвращает соответствующий праздник из перечисления Celebration.
     */
    private static Celebration determineHoliday(LocalDate date) {
        if (date.getMonthValue() == 1 && date.getDayOfMonth() == 1) {
            return Celebration.NEW_YEAR;
        } else if (date.getMonthValue() == 3 && date.getDayOfMonth() == 8) {
            return Celebration.MARCH_8;
        } else if (date.getMonthValue() == 2 && date.getDayOfMonth() == 23) {
            return Celebration.FEBRUARY_23;
        } else {
            return Celebration.NO_HOLIDAY;
        }
    }
}
