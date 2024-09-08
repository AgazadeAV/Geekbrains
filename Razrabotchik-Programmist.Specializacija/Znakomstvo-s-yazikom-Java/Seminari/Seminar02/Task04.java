/*Задание №4
Напишите метод, который составит строку, состоящую из 100
повторений слова TEST и метод, который запишет эту строку в
простой текстовый файл, обработайте исключения. */

package Seminari.Seminar02;

import java.io.FileWriter;

public class Task04 {
    public static void main(String[] args) {
        String str = "TEST";
        int n = 100;
        String newStr = stringMaker(str, n);
        String fileName = "text.txt";
        writeToFile(newStr, fileName);
    }

    public static String stringMaker(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str).append(" ");
        }
        return sb.toString();
    }

    public static void writeToFile(String str, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true)){
            fw.write(str);
            fw.write(System.lineSeparator());
            System.out.println("Success");
        } catch (Exception e){
            System.err.println("Error. File is not written.");
        }
    }
}







// public class Task04 {
// public static void main(String[] args) {
// String str = "TEST";
// int n = 100;
// String newStr = makeString(str, n);
// String fileName = "newFile.txt";

// try (FileWriter writer = new FileWriter(fileName)) {
// writer.write(newStr);
// System.out.println("Udacha.");
// } catch (IOException e) {
// System.err.println("Neudacha." + e.getMessage());
// }
// }

// public static String makeString(String str, int n){
// StringBuilder newStr = new StringBuilder();
// for (int i = 0; i < n; i++){
// newStr.append(str);
// }
// return newStr.toString();
// }
// }
