/*Задание №0
1. Создайте HashSet, заполните его следующими числами: {3, 6, 43, 8, 11, 7, 33, 3, 4, 8}.
Распечатайте содержимое данного множества.
2. Создайте LinkedHashSet, заполните его следующими числами: {3, 6, 43, 8, 11, 7, 33, 3, 4, 8}. 
Распечатайте содержимое данного множества.
3. Создайте TreeSet, заполните его следующими числами: {3, 6, 43, 8, 11, 7, 33, 3, 4, 8}.
Распечатайте содержимое данного множества. */

package Seminari.Seminar06;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task00 {

    public static void main(String[] args) {
        int[] numsArr = { 3, 6, 43, 8, 0, 11, 7, 33, 3, 4, 8, 55, -9, 0, 40 };

        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHasSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        addElToSet(numsArr, hashSet);
        addElToSet(numsArr, linkedHasSet);
        addElToSet(numsArr, treeSet);

        System.out.println(hashSet);
        System.out.println(linkedHasSet);
        System.out.println(treeSet);
    }

    private static void addElToSet(int[] numsArr, Set<Integer> set) {
        for (int i = 0; i < numsArr.length; i++) {
            set.add(numsArr[i]);
        }
    }
}