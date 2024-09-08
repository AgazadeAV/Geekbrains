/*Напишите метод, который вернет содержимое текущей папки в виде
массива строк.
Напишите метод, который запишет массив, возвращенный предыдущим
методом в файл.
Обработайте ошибки с помощью try-catch конструкции. В случае
возникновения исключения, оно должно записаться в лог-файл. */

package Seminari.Seminar02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task05 {
    private static Logger logger = Logger.getLogger(Task05.class.getName());

    public static void main(String[] args) {
        configLogger();
        String[] contentFolder = getFileList(System.getProperty("user.dir"));
        writeArrayToFile(contentFolder, "contentFolder.txt");
    }

    static String[] getFileList(String folderName) {
        File currentFolder = new File(folderName);
        return currentFolder.list();
    }

    static void configLogger() {
        try {
            // logger.setUseParentHandlers(false); отключить вывод лога в консоль
            FileHandler fh = new FileHandler("log.txt", true);
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeArrayToFile(String[] arr, String fileName) {
        try (FileWriter fr = new FileWriter(fileName)) {
            for (String elem : arr) {
                fr.write(elem);
                fr.write(System.lineSeparator());
            }
            logger.info("Данные успешно записаны.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            logger.warning("Ошибка записи в файл");
        }
    }
}