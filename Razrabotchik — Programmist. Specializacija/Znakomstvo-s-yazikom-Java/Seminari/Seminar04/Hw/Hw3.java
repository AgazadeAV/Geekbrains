package Seminari.Seminar04.Hw;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hw3 {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;
        a = 3;
        op = '+';
        b = 7;
        c = 4;
        op2 = '+';
        d = 7;
        undo = '<';
        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
        double result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        double prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}

class Calculator {
    private Deque<Double> deque;

    public Calculator() {
        deque = new ArrayDeque<>();
    }

    public double calculate(char op, int a, int b) {
        double result = 0.0;

        if (op == '+') {
            result = a + b;
            deque.addFirst(result);
        } else if (op == '-') {
            result = a - b;
            deque.addFirst(result);
        } else if (op == '*') {
            result = a * b;
            deque.addFirst(result);
        } else if (op == '/') {
            result = (double) a / b; // деление с учетом дробной части
            deque.addFirst(result);
        } else if (op == '<') {
            if (!deque.isEmpty()) {
                return deque.removeLast();
            } else {
                throw new IllegalStateException("Deque is empty");
            }
        }

        return deque.getFirst();
    }
}