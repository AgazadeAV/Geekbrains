/*Задание №1
Дано четное число N (>0) и символы c1 и c2.
Написать метод, который вернет строку длины N, которая
состоит из чередующихся символов c1 и c2, начиная с c1. */

package Seminari.Seminar02;

public class Task01 {
    public static void main(String[] args) {
        int n = 10;
        char c1 = 'a';
        char c2 = 'b';
        String newStr = makeString(n, c1, c2);
        System.out.println(newStr);
    }

    public static String makeString(int n, char a, char b) {
        StringBuilder str = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                str.append(a);
            } else {
                str.append(b);
            }
        }
        return str.toString();
    }
}
