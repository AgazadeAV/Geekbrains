/*Задание №4
Написать метод, который переведёт данное целое число в римский формат.

1000, "M"
900, "CM"
500, "D"
400, "CD"
100, "C"
90, "XC"
50, "L"
40, "XL"
10, "X"
9, "IX"
5, "V"
4, "IV"
1, "I" */

package Seminari.Seminar05;

// import java.util.Arrays;
// import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Task04 {
    public static void main(String[] args) {
        int arabicNum = 548;
        System.out.println(arabicToRoman(arabicNum));

    }

    public static Map<Integer, String> arabicRomanMap() {
        // Map<Integer, String> arabicMap = new HashMap<>();
        Map<Integer, String> arabicMap = new LinkedHashMap<>();

        arabicMap.put(1000, "M");
        arabicMap.put(900, "CM");
        arabicMap.put(500, "D");
        arabicMap.put(400, "CD");
        arabicMap.put(100, "C");
        arabicMap.put(90, "XC");
        arabicMap.put(50, "L");
        arabicMap.put(40, "XL");
        arabicMap.put(10, "X");
        arabicMap.put(9, "IX");
        arabicMap.put(5, "V");
        arabicMap.put(4, "IV");
        arabicMap.put(1, "I");

        return arabicMap;
    }

    public static String arabicToRoman(int arabicNum) {
        Map<Integer, String> arabicMap = arabicRomanMap();
        Set<Integer> arabicNumsSet = arabicMap.keySet();
        Integer[] arabicNumsArray = arabicNumsSet.toArray(new Integer[0]);
        // Arrays.sort(arabicNumsArray, (a, b) -> b - a);
        StringBuilder result = new StringBuilder();

        for (int num : arabicNumsArray) {
            while (arabicNum >= num) {
                arabicNum -= num;
                result.append(arabicMap.get(num));
            }
        }

        return result.toString();
    }
}
