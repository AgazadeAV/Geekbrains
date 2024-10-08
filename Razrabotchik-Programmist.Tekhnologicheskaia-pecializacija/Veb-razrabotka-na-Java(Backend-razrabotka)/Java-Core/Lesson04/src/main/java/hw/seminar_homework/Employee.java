package hw.seminar_homework;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс Employee представляет сотрудника с именем и полом.
 *
 * Аннотация {@code @Getter} автоматически генерирует геттеры для всех полей.
 * Аннотация {@code @Setter} автоматически генерирует сеттеры для всех полей.
 */
@Getter
@Setter
public class Employee {
    private String name; // Имя сотрудника
    private Customer.Gender gender; // Пол сотрудника

    /**
     * Конструктор класса Employee.
     *
     * @param name Имя сотрудника.
     * @param gender Пол сотрудника.
     */
    public Employee(String name, Customer.Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}
