import hw.lecture_homework.MatrixSum;
import hw.lecture_homework.exceptions.ColumnConversionException;
import hw.lecture_homework.exceptions.RowConversionException;
import hw.seminar_homework.Customer;
import hw.seminar_homework.Employee;
import hw.seminar_homework.Holiday;

/**
 * Основной класс программы, содержащий метод main для запуска программы.
 * <p>
 * В этом классе обрабатываются различные матрицы и демонстрируется работа с исключениями,
 * а также проводится работа с классами, связанными с сотрудниками и праздниками.
 * </p>
 */
public class Main {

    /**
     * Основной метод программы. Выполняет проверку корректных и некорректных матриц
     * и выводит результат либо сообщение об ошибке. Также вызывает методы для
     * работы с сотрудниками.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        System.out.println("Лекционное домашнее задание:");
        lectureHomework();
        System.out.println();
        System.out.println("Семинарское домашнее задание:");
        seminarHomework();
    }

    /**
     * Метод для выполнения домашнего задания из лекции.
     * <p>
     * Создает экземпляр класса {@link MatrixSum} и обрабатывает
     * несколько матриц, включая корректные и некорректные.
     * </p>
     */
    private static void lectureHomework() {
        // Экземпляр класса MatrixSum для выполнения операций
        MatrixSum matrixSumCalculator = new MatrixSum();

        // Пример корректной матрицы 5x5
        int[][] validMatrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        // Пример некорректной матрицы (строк меньше 5)
        int[][] invalidMatrixRows = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };

        // Пример некорректной матрицы (столбцов меньше 5)
        int[][] invalidMatrixColumns = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };

        // Обработка всех матриц
        processMatrix(matrixSumCalculator, validMatrix);
        processMatrix(matrixSumCalculator, invalidMatrixRows);
        processMatrix(matrixSumCalculator, invalidMatrixColumns);
    }



    /**
     * Метод для обработки матрицы. Вычисляет сумму элементов
     * и обрабатывает возможные исключения.
     *
     * @param matrixSumCalculator экземпляр класса {@link MatrixSum} для вычисления суммы.
     * @param matrix матрица целых чисел для обработки.
     */
    private static void processMatrix(MatrixSum matrixSumCalculator, int[][] matrix) {
        try {
            // Вычисление суммы элементов матрицы
            int sum = matrixSumCalculator.sumMatrix(matrix);
            System.out.println("Сумма элементов матрицы: " + sum);
        } catch (RowConversionException | ColumnConversionException e) {
            // Обработка исключений и вывод сообщения об ошибке
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод для выполнения домашнего задания из семинара.
     * <p>
     * Создает массив сотрудников и вызывает метод {@link Holiday#greetEmployees(Employee[])}
     * для поздравления сотрудников с праздниками.
     * </p>
     */
    private static void seminarHomework() {
        // Создание массива сотрудников
        Employee[] employees = {
                new Employee("Иван", Customer.Gender.MALE),
                new Employee("Анна", Customer.Gender.FEMALE)
        };

        // Поздравление сотрудников с праздниками
        Holiday.greetEmployees(employees);
    }
}
