/*Задание №2
Написать программу, определяющую правильность расстановки скобок в выражении.
Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь
Пример 3: [6+(3*3)] - истина
Пример 4: {a}[+]{(d*3)} - истина
Пример 5: <{a}+{(d*3)}> - истина
Пример 6: {a+]}{(d*3)} - ложь */

package Seminari.Seminar05;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task02 {
    public static void main(String[] args) {
        String[] strings = { "a+(d*3)", "[a+(1*3)", "[6+(3*3)]", "{a}[+]{(d*3)}", "<{a}+{(d*3)}>", "{a+]}{(d*3)}" };

        for (String str : strings) {
            boolean isValid = isBracketsCorrect(str);
            System.out.println(str + " -> " + isValid);
        }
    }

    public static Map<Character, Character> getBracketsMap() {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put('>', '<');
        return brackets;
    }

    public static boolean isBracketsCorrect(String expression) {
        Map<Character, Character> brackets = getBracketsMap();
        Stack<Character> stack = new Stack<>();

        for (Character c : expression.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
