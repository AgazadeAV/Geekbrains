import hw.lecture_homework.task01.Cat1;
import hw.lecture_homework.task02.Animal;
import hw.lecture_homework.task02.Bird;
import hw.lecture_homework.task02.Cat;
import hw.lecture_homework.task02.Dog;

import java.time.LocalDate;

/**
 * Главный класс, демонстрирующий работу с классами животных и их поведением.
 */
public class Main {

    public static void main(String[] args) {
        // Демонстрация работы с классом Cat1
        demonstrateCat1();

        // Демонстрация работы с животными (кот, собака, птица)
        demonstrateAnimalBehavior();
    }

    /**
     * Метод демонстрирует создание объектов класса Cat1 и вывод их данных.
     */
    private static void demonstrateCat1() {
        System.out.println("Домашнее задание №1 с лекции.");
        Cat1 cat1 = new Cat1("Murzik", "Green");
        Cat1 cat2 = new Cat1("Snezhok", "White", LocalDate.of(2018, 5, 20));

        System.out.println(cat1);
        System.out.println();
        System.out.println(cat2);
        System.out.println();
    }

    /**
     * Метод демонстрирует выполнение действий (бег, плавание, прыжки) для разных животных.
     */
    private static void demonstrateAnimalBehavior() {
        System.out.println("Домашнее задание №2 с лекции.");

        // Создание объектов животных
        Animal cat = new Cat("Whiskers", 200, 2);
        Animal dog = new Dog("Rex", 500, 10, 0.5);
        Animal bird = new Bird("Tweety", 50, 0, 0.2);

        // Демонстрация поведения кота
        demonstrateActions(cat, 150, 5, 1.5);

        // Демонстрация поведения собаки
        demonstrateActions(dog, 400, 5, 0.4);

        // Демонстрация поведения птицы
        demonstrateActions(bird, 30, 0, 0.1);
    }

    /**
     * Метод демонстрирует действия (бег, плавание, прыжки) для конкретного животного.
     *
     * @param animal      Объект животного
     * @param runDistance Расстояние для бега
     * @param swimDistance Расстояние для плавания
     * @param jumpHeight  Высота прыжка
     */
    private static void demonstrateActions(Animal animal, double runDistance, double swimDistance, double jumpHeight) {
        System.out.println(animal.getClass().getSimpleName() + " run: " + animal.run(runDistance));
        System.out.println(animal.getClass().getSimpleName() + " swim: " + animal.swim(swimDistance));
        System.out.println(animal.getClass().getSimpleName() + " jump: " + animal.jump(jumpHeight));
        System.out.println();
    }
}
