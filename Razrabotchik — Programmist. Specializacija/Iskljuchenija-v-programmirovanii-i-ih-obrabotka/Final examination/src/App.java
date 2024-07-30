import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileWriterUtil fileWriterUtil = new FileWriterUtil();

        while (true) {
            try {
                System.out.println("Введите данные в произвольном порядке (Фамилия Имя Отчество, Дата рождения, " +
                        "Номер телефона, Пол):");
                String inputLine = scanner.nextLine();
                String[] inputData = inputLine.split("\\s+");

                if (inputData.length != 6) {
                    throw new IllegalArgumentException("Неверное количество данных");
                }

                Person person = new Person(inputData);
                fileWriterUtil.writeToPersonFile(person);

                System.out.println("Данные успешно записаны.");
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.println("Продолжить ввод данных? (yes/no):");
            String continueInput = scanner.nextLine().trim().toLowerCase();
            if (!continueInput.equals("yes")) {
                break;
            }
        }

        fileWriterUtil.closeWriters();
        scanner.close();
    }
}
