package homework;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс, представляющий справочник сотрудников.
 */
@AllArgsConstructor
public class EmployeeBook {
    /**
     * Хранит сотрудников по табельным номерам.
     */
    private final Map<Integer, Employee> employeeMap;

    /**
     * Конструктор, создающий новый экземпляр справочника сотрудников.
     */
    public EmployeeBook() {
        this.employeeMap = new HashMap<>();
    }

    /**
     * Ищет сотрудников по стажу и возвращает список найденных сотрудников.
     *
     * @param expectedExperience Ожидаемый стаж работы.
     * @return Список сотрудников с заданным стажем.
     */
    public List<Employee> searchEmployeeByExperience(int expectedExperience) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getExperience() == expectedExperience)
                .collect(Collectors.toList());
    }

    /**
     * Возвращает список номеров телефонов сотрудников по имени.
     *
     * @param employeeName Имя сотрудника.
     * @return Список строк с именем и номером телефона сотрудников.
     */
    public List<String> searchEmployeePhoneNumberByName(String employeeName) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getName().equals(employeeName))
                .map(employee -> String.format("Имя сотрудника: %s, его номер: %s", employee.getName(), employee.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    /**
     * Ищет сотрудника по табельному номеру.
     *
     * @param providedId Табельный номер сотрудника.
     * @return Объект Employee, если найден, иначе null.
     */
    public Employee searchById(int providedId) {
        return employeeMap.get(providedId); // Быстрый поиск по табельному номеру
    }

    /**
     * Добавляет нового сотрудника в справочник.
     *
     * @param employee Новый сотрудник.
     * @return true, если добавление прошло успешно, и false, если сотрудник с таким табельным номером уже существует.
     */
    public boolean addEmployeeToEmployeeBook(Employee employee) {
        if (employeeMap.containsKey(employee.getId())) {
            return false; // Сотрудник с таким табельным номером уже существует
        }
        employeeMap.put(employee.getId(), employee); // Добавление в Map для быстрого поиска
        return true;
    }
}
