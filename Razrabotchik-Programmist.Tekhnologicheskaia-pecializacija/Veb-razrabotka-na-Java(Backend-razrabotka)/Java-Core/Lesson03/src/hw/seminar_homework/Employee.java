package hw.seminar_homework;

/**
 * Класс Employee представляет сотрудника.
 * Он содержит информацию об имени и зарплате сотрудника, а также методы для получения и изменения этих данных.
 * Также включает метод для сравнения двух дат.
 */
public class Employee {
    private String name;
    private double salary;

    /**
     * Конструктор для создания сотрудника с заданным именем и зарплатой.
     *
     * @param name   Имя сотрудника.
     * @param salary Зарплата сотрудника.
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Пустой конструктор для создания сотрудника без начальных данных.
     */
    public Employee() {

    }

    /**
     * Получить зарплату сотрудника.
     *
     * @return Зарплата сотрудника.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Установить новую зарплату сотрудника.
     *
     * @param salary Новая зарплата сотрудника.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Возвращает строковое представление сотрудника.
     *
     * @return Строковое представление сотрудника, включающее имя и зарплату.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    /**
     * Метод сравнивает две даты, каждая из которых представлена тремя параметрами: год, месяц и день.
     * Даты преобразуются в целые числа в формате "гггг", "мм", "дд", после чего выполняется их сравнение.
     *
     * @param year1  Год первой даты
     * @param month1 Месяц первой даты
     * @param day1   День первой даты
     * @param year2  Год второй даты
     * @param month2 Месяц второй даты
     * @param day2   День второй даты
     * @return       0, если даты равны; отрицательное число, если первая дата меньше второй;
     *               положительное число, если первая дата больше второй
     *
     * @see java.lang.Integer#compare(int, int)
     */
    public int compareDates(int year1, int month1, int day1, int year2, int month2, int day2) {
        // Преобразуем даты в число, представляющее количество дней
        // Чем больше число, тем "более поздняя" дата
        int date1 = year1 * 10000 + month1 * 100 + day1;
        int date2 = year2 * 10000 + month2 * 100 + day2;

        // Возвращаем результат сравнения чисел
        return Integer.compare(date1, date2);
    }
}
