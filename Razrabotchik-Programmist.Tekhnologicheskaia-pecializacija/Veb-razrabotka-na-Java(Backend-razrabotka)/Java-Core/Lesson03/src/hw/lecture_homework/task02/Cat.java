package hw.lecture_homework.task02;

/**
 * Класс Cat, представляющий кота, который может бегать и прыгать, но не любит плавать.
 */
public class Cat extends Animal {

    /**
     * Конструктор для создания кота с заданными параметрами бега и прыжков.
     *
     * @param name            Имя кота
     * @param maxRunDistance  Максимальное расстояние для бега
     * @param maxJumpHeight   Максимальная высота прыжка
     */
    public Cat(String name, double maxRunDistance, double maxJumpHeight) {
        // Коты не плавают, поэтому maxSwimDistance всегда 0
        super(name, maxRunDistance, 0, maxJumpHeight);
    }

    /**
     * Проверяет, может ли кот пробежать указанное расстояние.
     *
     * @param distance Расстояние для бега
     * @return true, если кот может пробежать указанное расстояние, иначе false
     */
    @Override
    public boolean run(double distance) {
        return distance <= maxRunDistance;
    }

    /**
     * Коты не плавают, поэтому этот метод всегда возвращает false.
     *
     * @param distance Расстояние для плавания
     * @return всегда false
     */
    @Override
    public boolean swim(double distance) {
        return false; // Коты не плавают
    }

    /**
     * Проверяет, может ли кот прыгнуть на указанную высоту.
     *
     * @param height Высота прыжка
     * @return true, если кот может прыгнуть на указанную высоту, иначе false
     */
    @Override
    public boolean jump(double height) {
        return height <= maxJumpHeight;
    }
}
