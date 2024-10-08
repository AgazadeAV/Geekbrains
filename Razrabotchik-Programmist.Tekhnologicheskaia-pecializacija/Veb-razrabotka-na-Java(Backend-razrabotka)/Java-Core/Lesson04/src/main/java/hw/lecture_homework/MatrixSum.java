package hw.lecture_homework;

import hw.lecture_homework.exceptions.ColumnConversionException;
import hw.lecture_homework.exceptions.RowConversionException;

/**
 * Класс для вычисления суммы элементов квадратной матрицы.
 * Ожидается, что матрица будет размером 5x5. Если матрица
 * имеет неверное количество строк или столбцов, выбрасываются соответствующие исключения.
 */
public class MatrixSum {
    private static final int EXPECTED_SIZE = 5;

    /**
     * Метод для вычисления суммы элементов матрицы.
     *
     * @param matrix матрица целых чисел, которую необходимо проверить и просуммировать.
     * @return сумма всех элементов матрицы.
     * @throws RowConversionException если количество строк не равно 5.
     * @throws ColumnConversionException если количество столбцов в одной из строк не равно 5.
     */
    public int sumMatrix(int[][] matrix) throws RowConversionException, ColumnConversionException {
        if (matrix.length != EXPECTED_SIZE) {
            throw new RowConversionException(EXPECTED_SIZE, matrix.length);
        }

        for (int[] row : matrix) {
            if (row.length != EXPECTED_SIZE) {
                throw new ColumnConversionException(EXPECTED_SIZE, row.length);
            }
        }

        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }

        return sum;
    }
}
