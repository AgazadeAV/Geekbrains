import lecture_homework.FileHandler;
import seminar_homework.backup_maker.BackupCreator;
import seminar_homework.tic_tac_toe.Board;
import seminar_homework.tic_tac_toe.BoardSaver;

/**
 * Главный класс приложения, содержащий метод main.
 *
 * Этот класс отвечает за выполнение резервного копирования файлов,
 * создание игрового поля для крестиков-ноликов и сохранение его состояния в файл.
 */
public class Main {

    public static void main(String[] args) {
        BackupCreator.createBackup("."); // Резервное копирование файлов
        saveGameBoard(); // Сохранение состояния доски игры
        performFileOperations(); // Выполнение операций с файлами
    }

    /**
     * Создает объект доски и сохраняет его состояние в файл.
     */
    private static void saveGameBoard() {
        int[] boardData = {1, 2, 0, 2, 1, 0, 1, 0, 0}; // Состояние игрового поля
        Board board = new Board(boardData); // Создаем объект доски

        BoardSaver.saveBoardToFile(board, "board.dat"); // Сохраняем доску в файл
    }

    /**
     * Выполняет операции с файлами: конкатенацию и поиск слова.
     * Объединяет несколько файлов в один и ищет указанное слово в результирующем файле.
     */
    private static void performFileOperations() {
        try {
            // Пример использования метода конкатенации файлов с записью в новый файл
            FileHandler.concatenateFiles("newFile.txt", "file1.txt", "file2.txt", "file3.txt");
            System.out.println("Файлы успешно объединены в newFile.txt.");

            // Пример поиска слова в файле
            boolean found = FileHandler.findWordInFile("newFile.txt", "example");
            System.out.println("Слово найдено в newFile.txt: " + found);

        } catch (Exception e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
