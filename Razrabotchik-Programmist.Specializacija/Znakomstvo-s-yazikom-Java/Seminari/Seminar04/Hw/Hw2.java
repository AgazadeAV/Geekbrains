package Seminari.Seminar04.Hw;

import java.util.LinkedList;

public class Hw2 {
    public static void main(String[] args) {
        MyQueue<Integer> queue;
        queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(5);
        System.out.println(queue.getElements());
        System.out.println();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());
        System.out.println();
        System.out.println(queue.first());
    }
}

class MyQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();

    public void enqueue(T element) {
        queue.addLast(element);
    }

    public T dequeue() {
        return queue.remove();
    }

    public T first() {
        return queue.get(0);
    }

    public LinkedList<T> getElements() {
        return queue;
    }
}