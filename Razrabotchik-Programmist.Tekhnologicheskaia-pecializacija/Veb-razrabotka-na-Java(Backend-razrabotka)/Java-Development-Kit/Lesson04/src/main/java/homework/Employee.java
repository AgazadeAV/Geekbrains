package homework;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

/**
 * Класс, представляющий сотрудника.
 */
@Getter
@ToString
public class Employee {
    @Getter(AccessLevel.NONE)
    private static int startPosition = 0;

    /**
     * Уникальный идентификатор сотрудника.
     */
    private final int id;

    /**
     * Имя сотрудника.
     */
    private final String name;

    /**
     * Номер телефона сотрудника.
     */
    private String phoneNumber;

    /**
     * Стаж работы сотрудника в годах.
     */
    private int experience;

    /**
     * Конструктор для создания нового экземпляра сотрудника.
     *
     * @param name         Имя сотрудника.
     * @param phoneNumber  Номер телефона сотрудника.
     * @param experience   Стаж работы сотрудника в годах.
     */
    public Employee(String name, String phoneNumber, int experience) {
        this.id = ++startPosition;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }
}
