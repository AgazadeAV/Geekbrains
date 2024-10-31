package homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс, представляющий задачу об обедающих философах. Создает философов и вилки (блокировки)
 * для решения задачи, где каждый философ поочередно размышляет и ест.
 */
public class DiningPhilosophers {
    /**
     * Количество философов и вилок
     */
    private static final int NUM_PHILOSOPHERS = 5;

    /**
     * Количество приемов пищи на философа
     */
    private static final int MEALS_PER_PHILOSOPHER = 3;

    /**
     * Массив философов
     */
    private final Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];

    /**
     * Массив вилок (блокировок), используемых философами
     */
    private final Lock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];

    /**
     * Конструктор инициализирует вилки и философов, а затем запускает каждого философа
     * в отдельном потоке.
     */
    public DiningPhilosophers() {
        // Инициализация вилок
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }

        // Инициализация философов
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            int leftFork = i;
            int rightFork = (i + 1) % NUM_PHILOSOPHERS;
            philosophers[i] = new Philosopher(i, forks[leftFork], forks[rightFork], MEALS_PER_PHILOSOPHER);
            new Thread(philosophers[i]).start();
        }
    }
}
