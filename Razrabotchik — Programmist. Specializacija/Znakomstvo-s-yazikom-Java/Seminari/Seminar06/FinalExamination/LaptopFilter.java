package Seminari.Seminar06.FinalExamination;

import java.util.*;

public class LaptopFilter {
    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("ModelA", 8, 512, "Windows", "Black"));
        laptops.add(new Laptop("ModelB", 16, 256, "Windows", "Silver"));
        laptops.add(new Laptop("ModelC", 8, 1024, "Linux", "Black"));
        laptops.add(new Laptop("ModelD", 4, 512, "MacOS", "White"));

        // Хранение доступных критериев фильтрации
        Map<Integer, String> criteriaMap = new HashMap<>();
        criteriaMap.put(1, "ram");
        criteriaMap.put(2, "hdd");
        criteriaMap.put(3, "os");
        criteriaMap.put(4, "color");

        Scanner scanner = new Scanner(System.in);
        // Хранение параметров фильтрации
        Map<String, String> filters = new HashMap<>();

        // Запрос критериев фильтрации у пользователя
        while (true) {
            try {
                // Вывод текущих выбранных критериев
                if (!filters.isEmpty()) {
                    System.out.println("Выбранные критерии:");
                    for (Map.Entry<String, String> entry : filters.entrySet()) {
                        System.out.println(STR."\{entry.getKey()}: \{entry.getValue()}");
                    }
                }
                // Вывод доступных критериев фильтрации
                System.out.println("Введите цифру, соответствующую необходимому критерию:");
                System.out.println("1 - ОЗУ");
                System.out.println("2 - Объем ЖД");
                System.out.println("3 - Операционная система");
                System.out.println("4 - Цвет");

                int criterion = scanner.nextInt();
                if (criteriaMap.containsKey(criterion)) {
                    String criterionKey = criteriaMap.get(criterion);
                    System.out.println("Введите значение для " + criterionKey + ":");
                    String value = scanner.next();
                    filters.put(criterionKey, value);
                } else {
                    System.out.println("Неверный критерий. Повторите ввод.");
                }

                // Запрос на продолжение ввода критериев
                System.out.println("Продолжить ввод критериев? (да/нет)");
                String continueInput = scanner.next();
                if (continueInput.equalsIgnoreCase("нет")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка ввода: " + e.getMessage());
                scanner.nextLine(); // очистка сканера
            }
        }
        scanner.close();

        // Фильтрация ноутбуков по введенным критериям
        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков, соответствующих указанным критериям.");
        } else {
            System.out.println("Ноутбуки, соответствующие критериям:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }

    // Метод для фильтрации ноутбуков по введенным критериям
    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        // Применение каждого фильтра
        for (Map.Entry<String, String> filter : filters.entrySet()) {
            String key = filter.getKey();
            String value = filter.getValue();

            switch (key) {
                case "ram":
                    int ram = Integer.parseInt(value);
                    filteredLaptops.removeIf(laptop -> laptop.ram != ram);
                    break;
                case "hdd":
                    int hdd = Integer.parseInt(value);
                    filteredLaptops.removeIf(laptop -> laptop.hdd != hdd);
                    break;
                case "os":
                    filteredLaptops.removeIf(laptop -> !laptop.os.equalsIgnoreCase(value));
                    break;
                case "color":
                    filteredLaptops.removeIf(laptop -> !laptop.color.equalsIgnoreCase(value));
                    break;
            }
        }
        return filteredLaptops;
    }
}
