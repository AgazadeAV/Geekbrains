package hw.seminar_homework;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс Customer представляет покупателя с именем и полом.
 *
 * Аннотация {@code @Getter} автоматически генерирует геттеры для всех полей.
 * Аннотация {@code @Setter} автоматически генерирует сеттеры для всех полей.
 */
@Getter
@Setter
public class Customer {
    /**
     * Перечисление Gender представляет возможные полы покупателя.
     */
    public enum Gender {
        MALE,  // Мужской пол
        FEMALE // Женский пол
    }

    private String name; // Имя покупателя
    private Gender gender; // Пол покупателя

    /**
     * Конструктор класса Customer.
     *
     * @param name Имя покупателя.
     * @param gender Пол покупателя.
     */
    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}
