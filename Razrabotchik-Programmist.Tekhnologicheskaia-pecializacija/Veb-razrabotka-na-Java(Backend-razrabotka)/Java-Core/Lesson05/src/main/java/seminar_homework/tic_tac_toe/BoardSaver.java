package seminar_homework.tic_tac_toe;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс для сохранения состояния доски в файл.
 */
public class BoardSaver {
    /**
     * Сохраняет состояние доски в указанный файл.
     *
     * @param board Доска, состояние которой необходимо сохранить.
     * @param filename Имя файла, в который будет сохранена доска.
     */
    public static void saveBoardToFile(Board board, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            for (int value : board.getBoard()) {
                // Упаковываем значения в один байт (в диапазоне 0-3)
                fos.write(value);
            }
            System.out.println("Данные записаны в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }
}
