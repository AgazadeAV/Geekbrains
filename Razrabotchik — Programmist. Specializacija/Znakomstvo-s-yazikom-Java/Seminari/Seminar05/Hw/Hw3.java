package Seminari.Seminar05.Hw;

public class Hw3 {
    public static void main(String[] args) {
        int[] arr = { 1000, 5, 7, 3, 2, 500, 13, 19 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int i, int n) {
        int left = i * 2 + 1; // левый дочерний элемент = 2*i + 1
        int right = i * 2 + 2; // правый дочерний элемент = 2*i + 2
        int largest = i; // Инициализируем наибольший как корень

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Если правый дочерний элемент больше самого большого элемента на данный момент
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Если самый большой элемент не корень
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Рекурсивно преобразуем в кучу затронутое поддерево
            heapify(arr, largest, n);
        }
    }
}
