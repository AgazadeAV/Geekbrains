package seminar.task03.version02;

/*
В рамках выполнения задачи необходимо:
3 бегуна должны прийти к старту гонки
Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
Программа должна отсчитать “На старт”, “Внимание”, “Марш”
Программа должна завершиться когда все участники закончат гонку.
Подумайте об использовании примитива синхронизации
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static final int COUNT_RUNNERS = 3;

    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }
}