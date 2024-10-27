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
    private static int startPositionForID = 0;

    /**
     * Уникальный идентификатор сотрудника.
     */
    private final int employeeID;

    /**
     * Имя сотрудника.
     */
    private final String employeeName;

    /**
     * Номер телефона сотрудника.
     */
    private String employeePhoneNumber;

    /**
     * Стаж работы сотрудника в годах.
     */
    private int employeeExperience;

    /**
     * Конструктор для создания нового экземпляра сотрудника.
     *
     * @param employeeName         Имя сотрудника.
     * @param employeePhoneNumber  Номер телефона сотрудника.
     * @param employeeExperience   Стаж работы сотрудника в годах.
     */
    public Employee(String employeeName, String employeePhoneNumber, int employeeExperience) {
        this.employeeID = ++startPositionForID;
        this.employeeName = employeeName;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeExperience = employeeExperience;
    }
}
