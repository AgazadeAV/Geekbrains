package hw.lecture_homework.task02;

/**
 * Класс Bird, представляющий птицу, которая может бегать, плавать и прыгать.
 */
public class Bird extends Animal {

    /**
     * Конструктор для создания птицы с заданными параметрами бега, плавания и прыжков.
     *
     * @param name            Имя птицы
     * @param maxRunDistance  Максимальное расстояние для бега
     * @param maxSwimDistance Максимальное расстояние для плавания
     * @param maxJumpHeight   Максимальная высота прыжка
     */
    public Bird(String name, double maxRunDistance, double maxSwimDistance, double maxJumpHeight) {
        super(name, maxRunDistance, maxSwimDistance, maxJumpHeight);
    }

    /**
     * Проверяет, может ли птица пробежать указанное расстояние.
     *
     * @param distance Расстояние для бега
     * @return true, если птица может пробежать указанное расстояние, иначе false
     */
    @Override
    public boolean run(double distance) {
        return distance <= maxRunDistance;
    }

    /**
     * Проверяет, может ли птица проплыть указанное расстояние.
     *
     * @param distance Расстояние для плавания
     * @return true, если птица может проплыть указанное расстояние, иначе false
     */
    @Override
    public boolean swim(double distance) {
        return distance <= maxSwimDistance;
    }

    /**
     * Проверяет, может ли птица прыгнуть на указанную высоту.
     *
     * @param height Высота прыжка
     * @return true, если птица может прыгнуть на указанную высоту, иначе false
     */
    @Override
    public boolean jump(double height) {
        return height <= maxJumpHeight;
    }
}
