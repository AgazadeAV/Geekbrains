/*
Написать классы кота, собаки, птицы, наследники животного. У всех есть
три действия: бежать, плыть, прыгать. Действия принимают размер
препятствия и возвращают булев результат. Три ограничения: высота
прыжка, расстояние, которое животное может пробежать, расстояние,
которое животное может проплыть. Следует учесть, что коты не любят воду.
Добавить механизм, создающий 25% разброс значений каждого
ограничения для каждого объекта животного
 */
package hw.lecture_homework.task02;

import java.util.Random;

/**
 * Абстрактный класс Animal, представляющий животное с возможностью бегать, плавать и прыгать.
 */
public abstract class Animal {
    protected String name; // Имя животного
    protected double maxRunDistance; // Максимальное расстояние для бега
    protected double maxSwimDistance; // Максимальное расстояние для плавания
    protected double maxJumpHeight; // Максимальная высота прыжка

    private Random random = new Random(); // Генератор случайных чисел для разброса

    /**
     * Конструктор для создания животного с определенными параметрами и применением разброса.
     *
     * @param name             Имя животного
     * @param maxRunDistance   Максимальное расстояние для бега
     * @param maxSwimDistance  Максимальное расстояние для плавания
     * @param maxJumpHeight    Максимальная высота прыжка
     */
    public Animal(String name, double maxRunDistance, double maxSwimDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = applyVariance(maxRunDistance);
        this.maxSwimDistance = applyVariance(maxSwimDistance);
        this.maxJumpHeight = applyVariance(maxJumpHeight);
    }

    /**
     * Применяет разброс 25% к значению ограничения.
     *
     * @param value Исходное значение ограничения
     * @return Новое значение с разбросом ±25%
     */
    private double applyVariance(double value) {
        double variance = 0.25 * value; // 25% от исходного значения
        return value + (random.nextDouble() * 2 - 1) * variance; // Разброс от -25% до +25%
    }

    /**
     * Метод для проверки, может ли животное пробежать заданное расстояние.
     *
     * @param distance Расстояние для бега
     * @return true, если животное может пробежать указанное расстояние, иначе false
     */
    public abstract boolean run(double distance);

    /**
     * Метод для проверки, может ли животное проплыть заданное расстояние.
     *
     * @param distance Расстояние для плавания
     * @return true, если животное может проплыть указанное расстояние, иначе false
     */
    public abstract boolean swim(double distance);

    /**
     * Метод для проверки, может ли животное прыгнуть на заданную высоту.
     *
     * @param height Высота прыжка
     * @return true, если животное может прыгнуть на указанную высоту, иначе false
     */
    public abstract boolean jump(double height);
}
