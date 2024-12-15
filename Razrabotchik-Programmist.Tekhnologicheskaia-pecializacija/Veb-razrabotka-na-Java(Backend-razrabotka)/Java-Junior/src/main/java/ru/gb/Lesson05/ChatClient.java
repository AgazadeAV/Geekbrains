package ru.gb.Lesson05;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Поток для чтения сообщений от сервера
            Thread readerThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            readerThread.start();

            // Основной поток для отправки сообщений
            Scanner scanner = new Scanner(System.in);
            System.out.println("Connected to chat. Type your messages (or /quit to exit):");
            while (true) {
                String message = scanner.nextLine();
                if ("/quit".equalsIgnoreCase(message.trim())) {
                    out.println(message); // Уведомляем сервер
                    break; // Завершаем цикл отправки
                }
                out.println(message);
            }

            System.out.println("Exiting chat...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
