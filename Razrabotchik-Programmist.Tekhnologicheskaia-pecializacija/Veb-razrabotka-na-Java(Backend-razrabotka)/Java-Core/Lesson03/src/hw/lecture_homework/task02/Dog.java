package hw.lecture_homework.task02;

/**
 * Класс Dog, представляющий собаку, которая может бегать, плавать и прыгать.
 */
public class Dog extends Animal {

    /**
     * Конструктор для создания собаки с заданными параметрами бега, плавания и прыжков.
     *
     * @param name            Имя собаки
     * @param maxRunDistance  Максимальное расстояние для бега
     * @param maxSwimDistance Максимальное расстояние для плавания
     * @param maxJumpHeight   Максимальная высота прыжка
     */
    public Dog(String name, double maxRunDistance, double maxSwimDistance, double maxJumpHeight) {
        super(name, maxRunDistance, maxSwimDistance, maxJumpHeight);
    }

    /**
     * Проверяет, может ли собака пробежать указанное расстояние.
     *
     * @param distance Расстояние для бега
     * @return true, если собака может пробежать указанное расстояние, иначе false
     */
    @Override
    public boolean run(double distance) {
        return distance <= maxRunDistance;
    }

    /**
     * Проверяет, может ли собака проплыть указанное расстояние.
     *
     * @param distance Расстояние для плавания
     * @return true, если собака может проплыть указанное расстояние, иначе false
     */
    @Override
    public boolean swim(double distance) {
        return distance <= maxSwimDistance;
    }

    /**
     * Проверяет, может ли собака прыгнуть на указанную высоту.
     *
     * @param height Высота прыжка
     * @return true, если собака может прыгнуть на указанную высоту, иначе false
     */
    @Override
    public boolean jump(double height) {
        return height <= maxJumpHeight;
    }
}
