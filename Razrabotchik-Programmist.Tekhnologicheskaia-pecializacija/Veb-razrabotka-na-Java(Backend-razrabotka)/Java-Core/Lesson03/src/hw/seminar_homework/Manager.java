package hw.seminar_homework;

/**
 * Класс Manager представляет руководителя и наследуется от класса Employee.
 * Он включает дополнительный статический метод для повышения зарплаты всех сотрудников, кроме руководителей.
 */
public class Manager extends Employee {

    /**
     * Конструктор для создания руководителя с заданным именем и зарплатой.
     *
     * @param name   Имя руководителя.
     * @param salary Зарплата руководителя.
     */
    public Manager(String name, double salary) {
        super(name, salary);
    }

    /**
     * Статический метод для повышения зарплаты всех сотрудников, кроме руководителей.
     * Метод проходит по массиву сотрудников и повышает их зарплату, если они не являются руководителями.
     * Зарплата округляется до двух знаков после запятой.
     *
     * @param employees Массив сотрудников (включая руководителей).
     * @param raise     Размер повышения в процентах.
     */
    public static void raiseSalaryForEmployees(Employee[] employees, double raise) {
        for (Employee employee : employees) {
            // Проверяем, что сотрудник не является руководителем
            if (!(employee instanceof Manager)) {
                double newSalary = employee.getSalary() * (1 + raise / 100);

                // Округляем до двух знаков после запятой
                newSalary = Math.round(newSalary * 100.0) / 100.0;

                employee.setSalary(newSalary);
            }
        }
    }
}
