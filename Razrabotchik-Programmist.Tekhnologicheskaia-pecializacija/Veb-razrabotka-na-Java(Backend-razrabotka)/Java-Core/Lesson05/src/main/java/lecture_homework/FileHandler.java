package lecture_homework;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

/**
 * Класс FileHandler предоставляет методы для работы с файлами, такие как
 * конкатенация содержимого нескольких файлов и поиск слова в файле.
 */
public class FileHandler {

    /**
     * Метод для конкатенации содержимого нескольких файлов и записи результата в новый файл.
     *
     * @param newFilePath путь к файлу, в который будет записано объединённое содержимое.
     * @param filePaths переменное количество путей к файлам, содержимое которых необходимо объединить.
     * @throws IOException если произошла ошибка при чтении или записи файла.
     */
    public static void concatenateFiles(String newFilePath, String... filePaths) throws IOException {
        // Открываем BufferedWriter для записи в новый файл
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(newFilePath))) {
            for (String filePath : filePaths) {
                // Чтение содержимого каждого файла
                String content = Files.readString(Paths.get(filePath));
                // Запись содержимого файла в итоговый файл
                writer.write(content);
                writer.newLine(); // Добавляем разделитель строк
            }
        }
    }

    /**
     * Метод для поиска конкретного слова в указанном файле.
     *
     * @param filePath путь к файлу, в котором будет производиться поиск слова.
     * @param word слово, которое необходимо найти.
     * @return true, если слово найдено в файле, иначе false.
     * @throws FileNotFoundException если указанный файл не найден.
     */
    public static boolean findWordInFile(String filePath, String word) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Читаем строку из файла
            if (line.contains(word)) { // Проверяем, содержит ли строка искомое слово
                scanner.close();
                return true; // Если слово найдено, возвращаем true
            }
        }
        scanner.close();
        return false; // Если слово не найдено, возвращаем false
    }
}

