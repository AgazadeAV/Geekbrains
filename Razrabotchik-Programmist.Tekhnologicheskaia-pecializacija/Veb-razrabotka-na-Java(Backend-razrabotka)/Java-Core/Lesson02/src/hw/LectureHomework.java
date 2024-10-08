package hw;

/**
 * Класс LectureHomework содержит методы для выполнения различных задач,
 * таких как шифрование методом Цезаря, циклический сдвиг массива и замена
 * элементов массива, состоящего из единиц и нулей.
 */
public class LectureHomework {

    /**
     * Метод для шифрования или расшифрования строки с использованием шифра Цезаря.
     *
     * @param text Строка для шифрования или расшифрования.
     * @param shift Сдвиг по алфавиту для каждого символа.
     * @param encrypt Булевый флаг, указывающий, нужно ли шифровать (true) или расшифровать (false) строку.
     * @return Строка, зашифрованная или расшифрованная с использованием шифра Цезаря.
     *
     * Описание работы метода:
     * - Если флаг encrypt равен false, сдвиг (shift) инвертируется для расшифрования.
     * - Каждый символ текста сдвигается на заданное количество позиций в алфавите.
     * - Символы, не являющиеся буквами, остаются неизменными.
     * - Работает с буквами как в верхнем регистре ('A'-'Z'), так и в нижнем ('a'-'z').
     */
    public String caesarCipher(String text, int shift, boolean encrypt) {
        // Если расшифровываем, инвертируем сдвиг
        if (!encrypt) {
            shift = -shift;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Проверяем, является ли символ буквой
            if (ch >= 'a' && ch <= 'z') {
                // Для маленьких букв
                ch = (char) ((ch - 'a' + shift + 26) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                // Для заглавных букв
                ch = (char) ((ch - 'A' + shift + 26) % 26 + 'A');
            }

            // Добавляем символ к результату
            result.append(ch);
        }

        return result.toString();
    }

    /**
     * Метод для циклического сдвига массива на n позиций. Последний элемент
     * становится первым при сдвиге.
     *
     * @param nums Массив целых чисел, который нужно сдвинуть.
     * @param n Количество позиций для циклического сдвига массива.
     * @return Новый массив, который является результатом циклического сдвига.
     *
     * Описание работы метода:
     * - Метод принимает массив чисел и сдвигает его на n позиций вправо.
     * - Если n больше длины массива, используется остаток от деления (n % длина массива).
     * - Последний элемент перемещается на первое место после сдвига.
     */
    public int[] cahngeValues(int[] nums, int n) {
        int len = nums.length;
        int[] changedNums = new int[len];

        // Ограничиваем сдвиг до длины массива
        n = n % len;

        for (int i = 0; i < len; i++) {
            // Циклический сдвиг с использованием остатка от деления
            changedNums[(i + n) % len] = nums[i];
        }

        return changedNums;
    }

    /**
     * Метод для замены всех единиц на нули и всех нулей на единицы в массиве.
     *
     * @param nums Массив целых чисел, состоящий только из единиц и нулей.
     * @return Новый массив, в котором все единицы заменены на нули, а нули на единицы.
     * Если массив содержит другие значения кроме 0 и 1, возвращается массив с одним элементом {-1}.
     *
     * Описание работы метода:
     * - Проверяется, состоит ли массив только из 0 и 1.
     * - Если массив корректен, каждое значение меняется: 0 -> 1 и 1 -> 0.
     * - Если в массиве есть другие числа, метод возвращает массив {-1}.
     */
    public int[] changeOneToZero(int[] nums) {
        int len = nums.length;
        int[] changedNums = new int[len];

        // Проверяем, состоит ли массив только из 0 и 1
        if (checkIfAllAreOneOrZero(nums)) {
            for (int i = 0; i < nums.length; i++) {
                // Замена: 0 -> 1, 1 -> 0
                changedNums[i] = nums[i] == 0 ? 1 : 0;
            }

            return changedNums;
        }

        // Возвращаем массив {-1}, если есть другие значения
        return new int[]{-1};
    }

    /**
     * Вспомогательный метод для проверки, состоит ли массив только из 0 и 1.
     *
     * @param nums Массив целых чисел для проверки.
     * @return true, если все элементы массива равны 0 или 1, иначе false.
     */
    private boolean checkIfAllAreOneOrZero(int[] nums) {
        for (int num : nums) {
            // Если элемент не равен ни 0, ни 1, возвращаем false
            if (num != 0 && num != 1) {
                return false;
            }
        }

        return true;
    }
}
