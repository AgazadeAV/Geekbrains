package hw.lecture_homework.exceptions;

/**
 * Исключение, выбрасываемое при ошибке в количестве строк матрицы.
 * Ожидается, что количество строк будет равно 5.
 */
public class RowConversionException extends Exception {

    /**
     * Конструктор исключения для ошибки количества строк.
     *
     * @param expected ожидаемое количество строк.
     * @param actual фактическое количество строк.
     */
    public RowConversionException(int expected, int actual) {
        super("Ошибка преобразования: ожидалось " + expected + " строк, но было " + actual);
    }
}
