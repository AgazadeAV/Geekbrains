package Seminari.Seminar03.Hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hw3 {
    public static void main(String[] args) {
        int[] nums = new int[] { -2, -1, 0, 1, 2, 3, 4, 5 };
        analyzeNumbers(nums);
    }

    private static void analyzeNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        double sum = 0;
        for (Integer elem : arr) {
            list.add(elem);
            sum += elem;
        }

        Collections.sort(list);
        int max = list.get(list.size() - 1);
        int min = list.get(0);
        double avg = sum / list.size();

        System.out.println(list);
        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + max);
        System.out.println("Average is = " + avg);

    }
}
