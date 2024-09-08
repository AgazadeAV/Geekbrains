/*Реализовать консольное приложение, которое:
1. Принимает от пользователя строку вида
text~num
2. Нужно рассплитить строку по ~, сохранить text в связный список на
позицию num.
3. Если введено print~num, выводит строку из позиции num в связном
списке и удаляет её из списка. */

package Seminari.Seminar04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input string like 'text~num' for adding to the list:");
            System.out.println("Input like 'print~num' for out and remove elem from the list:");
            System.out.println("Input 'q' for exit:");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Good bye!");
                break;
            }

            String[] inputSplit = input.split("~");
            String text = inputSplit[0];
            int num = Integer.parseInt(inputSplit[1]);

            if (text.equals("print")) {
                if (num >= 0 && num < list.size()) {
                    System.out.println(list.get(num));
                    list.remove(num);
                } else {
                    System.out.println("Incorrect num");
                }
                System.out.println(list);

            } else {
                if (num >= 0 && num <= list.size()) {
                    list.add(num, text);
                } else {
                    System.out.println("Incorrect num");
                }
                System.out.println(list);
            }
        }

        scanner.close();
    }
}
