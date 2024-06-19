/*1) Написать метод, который принимает массив элементов, помещает их в стэк
и выводит на консоль содержимое стэка.
2) Написать метод, который принимает массив элементов, помещает их в
очередь и выводит на консоль содержимое очереди. */

package Seminari.Seminar04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task03 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7 };
        printStack(nums);
        System.out.println();
        printQueue(nums);
    }

    public static void printStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (Integer elem : nums) {
            stack.push(elem);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void printQueue(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer elem : nums) {
            queue.add(elem);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
