package seminar_homework.ex3;

import lecture_homework.fruit.Apple;
import lecture_homework.fruit.Orange;

/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Main {
    public static void main(String[] args) {
        Pair<Orange, Apple> pair = new Pair<>(new Orange(), new Apple());
        System.out.println(pair);
    }
}
