/*Задание №5
Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг
прелестный Пора красавица проснись.
Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с
одинаковой длиной не должны “потеряться”.
*/

package Seminari.Seminar05;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Task05 {
    public static void main(String[] args) {
        String text = "The sun was setting behind the distant hills casting a warm golden glow over the fields";
        System.out.println(text);
        System.out.println(stringSort(text));
    }

    public static String stringSort(String text) {
        String[] textArray = text.split(" ");
        Map<Integer, LinkedList<String>> stringsMap = new TreeMap<>();
        for (String word : textArray) {
            if (stringsMap.containsKey(word.length())) {
                stringsMap.get(word.length()).add(word);
            } else {
                LinkedList<String> newList = new LinkedList<>();
                newList.add(word);
                stringsMap.put(word.length(), newList);
            }
        }

        StringBuilder sortedText = new StringBuilder();
        for (LinkedList<String> list : stringsMap.values()) {
            for (String word : list) {
                sortedText.append(word).append(" ");
            }
        }

        return sortedText.toString().trim();
    }
}
