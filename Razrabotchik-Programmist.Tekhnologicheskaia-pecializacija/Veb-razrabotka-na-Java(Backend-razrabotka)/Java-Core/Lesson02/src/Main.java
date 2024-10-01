import hw.LectureHomework;
import hw.SeminarHomework;

/**
 * Главный класс, содержащий метод main для запуска программы.
 * Этот класс демонстрирует использование методов из классов
 * SeminarHomework и LectureHomework.
 */
public class Main {
    /**
     * Метод main - точка входа в программу.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создание экземпляров классов SeminarHomework и LectureHomework
        SeminarHomework seminarHomework = new SeminarHomework();
        LectureHomework lectureHomework = new LectureHomework();

        // Пример массива для задач семинара
        int[] nums = {2, 0, 2, 0, 0, 4};

        // Выполнение задач семинара
        printSeminarResults(seminarHomework, nums);

        // Выполнение задач лекции
        printLectureResults(lectureHomework);
    }

    /**
     * Метод для вывода результатов семинарских задач.
     *
     * @param seminarHomework экземпляр класса SeminarHomework
     * @param nums массив чисел для обработки
     */
    private static void printSeminarResults(SeminarHomework seminarHomework, int[] nums) {
        System.out.println("Семинар. Задача 01.");
        System.out.println("Количество чётных чисел: " + seminarHomework.countEvens(nums));
        System.out.println();

        System.out.println("Семинар. Задача 02.");
        System.out.println("Разница между максимальным и минимальным значением: " + seminarHomework.maxMinDifference(nums));
        System.out.println();

        System.out.println("Семинар. Задача 03.");
        System.out.println("Есть ли два соседних нуля: " + seminarHomework.hasTwoConsecutiveZeros(nums));
        System.out.println();
    }

    /**
     * Метод для вывода результатов лекционных задач.
     *
     * @param lectureHomework экземпляр класса LectureHomework
     */
    private static void printLectureResults(LectureHomework lectureHomework) {
        // Задача 1 лекции: Шифр Цезаря
        System.out.println("Лекция. Задача 01.");
        System.out.println("Реализовать шифр Цезаря, который сдвигает каждую букву на заданное количество позиций.");
        System.out.println(lectureHomework.caesarCipher("Azer", 5, true));
        System.out.println();

        // Задача 2 лекции: Циклический сдвиг массива
        System.out.println("Лекция. Задача 02.");
        System.out.println("Изменить значения в массиве циклическим сдвигом массива на n позиций.");
        int[] numsForChange = {0, 5, 0, 3, 1, 9, 9, 5};
        System.out.println("Массив до изменений:");
        printArray(numsForChange);

        int[] changedNums = lectureHomework.cahngeValues(numsForChange, 5); // Исправление опечатки
        System.out.println("Массив после изменений:");
        printArray(changedNums);
        System.out.println();

        // Задача 3 лекции: Замена единиц на нули
        System.out.println("Лекция. Задача 03.");
        System.out.println("Заменить все единицы в массиве на нули, но оставить только первое вхождение единицы.");
        int[] oneZeroNums = {1, 1, 1, 0, 1, 0, 0, 1};
        System.out.println("Массив до изменений:");
        printArray(oneZeroNums);

        int[] changedOneZeroNums = lectureHomework.changeOneToZero(oneZeroNums);
        System.out.println("Массив после изменений:");
        printArray(changedOneZeroNums);
        System.out.println();
    }

    /**
     * Метод для печати элементов массива.
     *
     * @param array массив чисел для печати
     */
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
