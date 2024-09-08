/*Задание №3
Напишите метод, который принимает на вход строку (String) и
определяет является ли строка палиндромом (возвращает
boolean значение). */

package Seminari.Seminar02;

public class Task03 {
    public static void main(String[] args) {
        String polyndrom = "qwertyytrewq";
        if (isPolyndrom(polyndrom)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static boolean isPolyndrom(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}