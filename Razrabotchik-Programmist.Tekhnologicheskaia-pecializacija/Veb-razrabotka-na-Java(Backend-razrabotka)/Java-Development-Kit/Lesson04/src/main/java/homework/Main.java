package homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee employee1 = new Employee("Иван Иванов", "1234567890", 5);
        Employee employee2 = new Employee("Петр Петров", "9876543210", 3);

        employeeBook.addEmployeeToEmployeeBook(employee1);
        employeeBook.addEmployeeToEmployeeBook(employee2);

        List<Employee> experiencedEmployees = employeeBook.searchEmployeeByExperience(5);
        List<String> phoneNumbers = employeeBook.searchEmployeePhoneNumberByName("Иван Иванов");
        Employee foundEmployee = employeeBook.searchEmployeeByID(1);

        System.out.println("Сотрудники с 5-летним стажем: " + experiencedEmployees);
        System.out.println("Номера телефонов сотрудников по имени 'Иван Иванов': " + phoneNumbers);
        System.out.println("Найденный сотрудник по ID 1: " + foundEmployee);
    }
}
