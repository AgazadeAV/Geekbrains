package seminar_homework.ex1;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
над которыми должна быть произведена операция.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(0.4f, 12));
        System.out.println(Calculator.subtract(0.4f, 12));
        System.out.println(Calculator.multiply(0.4f, 12));
        System.out.println(Calculator.divide(0.4f, 12));
    }
}
