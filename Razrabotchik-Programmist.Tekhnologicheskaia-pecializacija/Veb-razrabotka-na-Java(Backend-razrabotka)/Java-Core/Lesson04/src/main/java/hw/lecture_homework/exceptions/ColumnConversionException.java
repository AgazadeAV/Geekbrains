package hw.lecture_homework.exceptions;

/**
 * Исключение, выбрасываемое при ошибке в количестве столбцов матрицы.
 * Ожидается, что количество столбцов будет равно 5 в каждой строке.
 */
public class ColumnConversionException extends Exception {

    /**
     * Конструктор исключения для ошибки количества столбцов.
     *
     * @param expected ожидаемое количество столбцов.
     * @param actual фактическое количество столбцов.
     */
    public ColumnConversionException(int expected, int actual) {
        super("Ошибка преобразования: ожидалось " + expected + " столбцов, но было " + actual);
    }
}

