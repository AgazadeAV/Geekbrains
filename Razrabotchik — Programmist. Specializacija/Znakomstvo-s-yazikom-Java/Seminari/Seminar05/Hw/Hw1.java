package Seminari.Seminar05.Hw;

import java.util.ArrayList;
import java.util.HashMap;

public class Hw1 {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        String name1 = "Ivanov";
        String name2 = "Petrov";
        int phone1 = 123456;
        int phone2 = 654321;
        add(name1, phone1);
        add(name1, phone2);
        add(name2, phone2);
        System.out.println(find(name1));
        System.out.println(getPhoneBook());
        System.out.println(find("Me"));
    }

    public static void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(phoneNum);
            phoneBook.put(name, newList);
        }
    }

    public static ArrayList<Integer> find(String name) {
        ArrayList<Integer> empty = new ArrayList<>();
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            return empty;
        }
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}
