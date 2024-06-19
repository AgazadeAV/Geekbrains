package Seminari.Seminar04.Hw;

import java.util.LinkedList;

public class Hw1 {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();
        ll.add(1);
        ll.add("One");
        ll.add(2);
        ll.add("Two");
        ll.add(3);
        ll.add("Three");
        System.out.println(ll);
        LinkedList<Object> reversedList = revert(ll);
        System.out.println(reversedList);
    }

    public static LinkedList<Object> revert(LinkedList<Object> ll) {
      LinkedList<Object> lls = new LinkedList<Object>();
      for(int i = ll.size() - 1; i >= 0; i--){
        lls.add(ll.get(i));
      }
      return lls;
}
}