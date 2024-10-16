package seminar_homework.backup_maker;

import java.io.File;

/**
 * Класс для создания резервных копий файлов в заданной директории.
 */
public class BackupCreator {

    /**
     * Создает резервные копии всех файлов в указанной директории.
     *
     * @param sourceDir Путь к директории, содержащей файлы для резервного копирования.
     */
    public static void createBackup(String sourceDir) {
        File sourceDirectory = new File(sourceDir);
        File backupDirectory = new File("./backup");

        // Создаем папку для бэкапов, если она не существует
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        // Перебираем все файлы в исходной директории
        File[] files = sourceDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                FileBackup fileBackup = new FileBackup(file);
                fileBackup.backupTo(backupDirectory); // Копируем файл в папку ./backup
            }
        } else {
            System.out.println("Директория не найдена или пуста.");
        }
    }
}
