package Seminari.Seminar06.Task0304;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CatMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", 2011, "Black", "Ivanov Ivan");
        Cat cat2 = new Cat("Murzik", 2020, "White", "Petrov Petr");
        Cat cat3 = new Cat("Beliash", 2015, "Threecolored", "Maliatin Aleksandr");
        Cat cat4 = new Cat("Beliash", 2015, "Threecolored", "Maliatin Aleksandr");
        Cat cat5 = new Cat("Vaska", 2011, "Black", "Ivanov Ivan");

        Set<Cat> cats = new HashSet<>(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

        for (Cat cat : cats) {
            System.out.println(cat);
            System.out.println();
        }
    }
}
