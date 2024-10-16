package seminar_homework.backup_maker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Класс для представления файла и его резервного копирования.
 */
public class FileBackup {
    private File file;

    /**
     * Конструктор для создания объекта FileBackup.
     *
     * @param file Файл, который необходимо резервировать.
     */
    public FileBackup(File file) {
        this.file = file;
    }

    /**
     * Резервное копирование файла в указанную директорию.
     *
     * @param destinationDirectory Директория, куда будет скопирован файл.
     */
    public void backupTo(File destinationDirectory) {
        if (file.isFile()) {
            Path sourcePath = file.toPath();
            Path destinationPath = new File(destinationDirectory, file.getName()).toPath();
            try {
                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Скопирован файл: " + file.getName());
            } catch (IOException e) {
                System.err.println("Ошибка при копировании файла: " + file.getName());
                e.printStackTrace();
            }
        }
    }
}
