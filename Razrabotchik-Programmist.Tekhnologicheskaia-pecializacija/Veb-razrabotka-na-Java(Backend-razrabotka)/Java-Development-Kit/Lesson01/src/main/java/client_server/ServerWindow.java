package client_server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JLabel statusLabel = new JLabel("Server is OFF", SwingConstants.CENTER);
    private boolean isServerWorking;
    private final List<ClientGUI> clients = new ArrayList<>();
    private final List<String> chatHistory = new ArrayList<>(); // Хранение истории чата

    public ServerWindow() {
        isServerWorking = false;

        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        statusLabel.setForeground(Color.RED);
        updateStatusLabel();

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    JOptionPane.showMessageDialog(ServerWindow.this, "Server is not running!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    isServerWorking = false;
                    appendLog("Server stopped: " + isServerWorking + "\n");
                    updateStatusLabel();
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    JOptionPane.showMessageDialog(ServerWindow.this, "Server is already running!", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    isServerWorking = true;
                    appendLog("Server started: " + isServerWorking + "\n");
                    loadChatHistory(); // Загружаем историю сообщений при запуске сервера
                    updateStatusLabel();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Server");
        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void appendLog(String message) {
        log.append(message);
        log.setCaretPosition(log.getDocument().getLength());
    }

    private void updateStatusLabel() {
        statusLabel.setText(isServerWorking ? "Server is ON" : "Server is OFF");
    }

    public void addClient(ClientGUI client) {
        clients.add(client);
        sendChatHistory(client); // Отправляем историю чата при подключении клиента
    }

    public void receiveMessage(String login, String message) {
        if (isServerWorking) {
            appendLog(login + ": " + message + "\n");
            chatHistory.add(login + ": " + message); // Сохраняем сообщение в истории
            // Уведомляем всех клиентов о новом сообщении
            for (ClientGUI client : clients) {
                client.appendLog(login + ": " + message);
            }
            saveMessageToFile(login + ": " + message); // Сохраняем сообщение в файл
        }
    }

    private void sendChatHistory(ClientGUI client) {
        if (!chatHistory.isEmpty()) { // Проверяем, есть ли история чата
            for (String message : chatHistory) {
                client.appendLog(message); // Отправляем каждое сообщение клиенту
            }
        }
    }

    private void saveMessageToFile(String message) {
        try (FileWriter writer = new FileWriter("chat_history.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для загрузки истории чата при старте сервера
    private void loadChatHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("chat_history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                chatHistory.add(line); // Загружаем в историю
                appendLog(line + "\n"); // Отображаем в логах сервера
            }
            // После загрузки истории отправляем её всем клиентам
            for (ClientGUI client : clients) {
                sendChatHistory(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
