import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FileWriterUtil implements AutoCloseable{
    private Map<String, PrintWriter> fileWriters = new HashMap<>();

    public void writeToPersonFile(Person person) {
        String fileName = person.getLastName() + ".txt";
        try {
            PrintWriter writer = fileWriters.computeIfAbsent(fileName, f -> {
                try {
                    return new PrintWriter(new FileWriter(f, true));
                } catch (IOException e) {
                    throw new RuntimeException("Ошибка при открытии файла " + f, e);
                }
            });

            writer.println(person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        for (PrintWriter writer : fileWriters.values()) {
            writer.close();
        }
        fileWriters.clear();
    }
}
