package Seminari.Seminar03.Hw;

public class Hw1 {
    // Метод для сортировки массива
    public static int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }

        // Разделяем массив на две части
        int mid = a.length / 2;
        int[] left = new int[mid];
        int[] right = new int[a.length - mid];
        
        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length - mid);
        
        // Рекурсивно сортируем каждую часть
        left = mergeSort(left);
        right = mergeSort(right);
        
        // Сливаем отсортированные части
        return merge(left, right);
    }
    
    // Метод для слияния двух отсортированных массивов в один
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0; // Индекс для левой части
        int j = 0; // Индекс для правой части
        int k = 0; // Индекс для результирующего массива
        
        // Слияние двух отсортированных массивов
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        // Копируем оставшиеся элементы левой части, если они есть
        while (i < left.length) {
            result[k++] = left[i++];
        }
        
        // Копируем оставшиеся элементы правой части, если они есть
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
    
    // Главный метод для запуска примера
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        
        System.out.println("List before sorting:");
        printArray(array);
        
        int[] sorted = mergeSort(array);
        
        System.out.println("\nList after sorting:");
        printArray(sorted);
    }
    
    // Метод для вывода массива на экран
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
