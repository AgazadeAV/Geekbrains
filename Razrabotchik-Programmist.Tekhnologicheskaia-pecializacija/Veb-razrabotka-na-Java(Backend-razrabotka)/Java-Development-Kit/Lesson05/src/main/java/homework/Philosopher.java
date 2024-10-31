package homework;

import java.util.concurrent.locks.Lock;

/**
 * Представляет философа в задаче об обедающих философах.
 * Каждый философ поочередно размышляет и ест, используя две вилки (блокировки) для еды.
 */
public class Philosopher implements Runnable {
    /**
     * Уникальный идентификатор философа
     */
    private final int id;

    /**
     * Блокировка для левой вилки, необходимой для еды
     */
    private final Lock leftFork;

    /**
     * Блокировка для правой вилки, необходимой для еды
     */
    private final Lock rightFork;

    /**
     * Общее количество приемов пищи, которые философ должен съесть
     */
    private final int mealsToEat;

    /**
     * Счетчик количества съеденных приемов пищи
     */
    private int mealsEaten = 0;

    /**
     * Конструктор для создания философа.
     *
     * @param id          уникальный идентификатор философа
     * @param leftFork    блокировка для левой вилки
     * @param rightFork   блокировка для правой вилки
     * @param mealsToEat  количество приемов пищи, которые философ должен съесть
     */
    public Philosopher(int id, Lock leftFork, Lock rightFork, int mealsToEat) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mealsToEat = mealsToEat;
    }

    /**
     * Основной метод выполнения, в котором философ поочередно размышляет и ест,
     * пока не достигнет заданного количества приемов пищи.
     */
    @Override
    public void run() {
        try {
            while (mealsEaten < mealsToEat) {
                think();
                eat();
            }
            System.out.println("Философ " + id + " закончил трапезу.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Философ " + id + " был прерван.");
        }
    }

    /**
     * Метод, имитирующий размышление философа.
     *
     * @throws InterruptedException если поток был прерван во время размышлений
     */
    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    /**
     * Метод, имитирующий процесс еды философа. Блокирует обе вилки перед началом еды и
     * освобождает их после завершения.
     *
     * @throws InterruptedException если поток был прерван во время еды
     */
    private void eat() throws InterruptedException {
        // Блокируем обе вилки одновременно
        leftFork.lock();
        rightFork.lock();
        try {
            mealsEaten++;
            System.out.println("Философ " + id + " ест. Еда № " + mealsEaten);
            Thread.sleep((long) (Math.random() * 1000));
        } finally {
            // Освобождаем вилки после еды
            leftFork.unlock();
            rightFork.unlock();
        }
    }
}
