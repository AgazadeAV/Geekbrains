/*Задание №1
Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными
и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить на
некоторую букву во втором слове, при этом
1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением
порядка следования. (Например, add - egg изоморфны)
2. буква может не меняться, а остаться такой же. (Например, note - code)
Пример 1:
Input: s = "foo", t = "bar"
Output: false
Пример 2:
Input: s = "paper", t = "title"
Output: true*/

package Seminari.Seminar05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word1 = s.nextLine();
        String word2 = s.nextLine();
        System.out.println(isIsomorphicSee(word1, word2));
        s.close();
    }

    public static boolean isIsomorphicSee(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }

        Map<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (hm.containsKey(c1) && c2 != hm.get(c1)) {
                return false;
            } else {
                hm.put(c1, c2);
            }
        }
        return true;
    }
}
