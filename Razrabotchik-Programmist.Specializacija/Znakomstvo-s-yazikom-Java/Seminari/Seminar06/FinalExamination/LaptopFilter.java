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
        laptops.add(new Laptop("ModelE", 8, 256, "Windows", "Red"));
        laptops.add(new Laptop("ModelF", 16, 512, "Linux", "Silver"));
        laptops.add(new Laptop("ModelG", 32, 1024, "Windows", "Black"));
        laptops.add(new Laptop("ModelH", 8, 128, "MacOS", "White"));
        laptops.add(new Laptop("ModelI", 4, 256, "Linux", "Black"));
        laptops.add(new Laptop("ModelJ", 8, 512, "Windows", "Blue"));
        laptops.add(new Laptop("ModelK", 16, 1024, "Linux", "Red"));
        laptops.add(new Laptop("ModelL", 32, 2048, "MacOS", "Silver"));
        laptops.add(new Laptop("ModelM", 4, 128, "Windows", "Black"));
        laptops.add(new Laptop("ModelN", 8, 256, "Linux", "White"));
        laptops.add(new Laptop("ModelO", 16, 512, "Windows", "Red"));
        laptops.add(new Laptop("ModelP", 32, 1024, "MacOS", "Black"));
        laptops.add(new Laptop("ModelQ", 8, 2048, "Linux", "Silver"));
        laptops.add(new Laptop("ModelR", 16, 256, "Windows", "Blue"));
        laptops.add(new Laptop("ModelS", 4, 512, "MacOS", "White"));
        laptops.add(new Laptop("ModelT", 32, 128, "Linux", "Black"));

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
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
                // Вывод доступных критериев фильтрации
                System.out.println("Введите цифру, соответствующую необходимому критерию:");
                System.out.println("1 - ОЗУ");
                System.out.println("2 - Объем ЖД");
                System.out.println("3 - Операционная система");
                System.out.println("4 - Цвет");

                int criterion = scanner.nextInt();
                scanner.nextLine(); // очистка сканера

                if (criteriaMap.containsKey(criterion)) {
                    String criterionKey = criteriaMap.get(criterion);
                    System.out.println("Введите значение для " + criterionKey + ":");
                    String value = scanner.nextLine();
                    filters.put(criterionKey, value);
                } else {
                    System.out.println("Неверный критерий. Повторите ввод.");
                }

                // Запрос на продолжение ввода критериев
                System.out.println("Продолжить ввод критериев? (да/нет)");
                String continueInput = scanner.nextLine();
                if (!continueInput.equalsIgnoreCase("да")) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода. Повторите попытку.");
                scanner.nextLine(); // очистка сканера
            }
        }
        scanner.close();

        // Фильтрация ноутбуков по введенным критериям
        Set<Laptop> filteredLaptops = filterLaptops(new HashSet<>(laptops), filters);
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
                    filteredLaptops.removeIf(laptop -> laptop.getRam() != ram);
                    break;
                case "hdd":
                    int hdd = Integer.parseInt(value);
                    filteredLaptops.removeIf(laptop -> laptop.getHdd() != hdd);
                    break;
                case "os":
                    filteredLaptops.removeIf(laptop -> !laptop.getOs().equalsIgnoreCase(value));
                    break;
                case "color":
                    filteredLaptops.removeIf(laptop -> !laptop.getColor().equalsIgnoreCase(value));
                    break;
            }
        }
        return filteredLaptops;
    }
}
