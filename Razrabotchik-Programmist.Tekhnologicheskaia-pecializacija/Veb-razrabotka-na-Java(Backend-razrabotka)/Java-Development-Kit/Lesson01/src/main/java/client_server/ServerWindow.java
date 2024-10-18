package client_server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final JLabel statusLabel = new JLabel("Server is OFF", SwingConstants.CENTER); // Надпись о состоянии сервера
    private boolean isServerWorking;

    // Список клиентов
    private final List<ClientGUI> clients = new ArrayList<>();

    public ServerWindow() {
        isServerWorking = false;

        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);

        // Настройка надписи о состоянии сервера
        statusLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Устанавливаем размер и стиль шрифта
        statusLabel.setForeground(Color.RED); // Устанавливаем красный цвет
        updateStatusLabel(); // Обновляем надпись

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    JOptionPane.showMessageDialog(ServerWindow.this, "Server is not running!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    isServerWorking = false;
                    appendLog("Server stopped: " + isServerWorking + "\n");
                    updateStatusLabel(); // Обновляем надпись
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
                    updateStatusLabel(); // Обновляем надпись
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

        add(statusLabel, BorderLayout.NORTH); // Добавляем надпись в верхнюю часть окна

        setVisible(true);
    }

    private void appendLog(String message) {
        log.append(message);
        log.setCaretPosition(log.getDocument().getLength());
    }

    private void updateStatusLabel() {
        // Обновляем текст в зависимости от состояния сервера
        if (isServerWorking) {
            statusLabel.setText("Server is ON");
        } else {
            statusLabel.setText("Server is OFF");
        }
    }

    public void addClient(ClientGUI client) {
        clients.add(client); // Добавляем клиента в список
    }

    public void receiveMessage(String login, String message) {
        if (isServerWorking) {
            appendLog(login + ": " + message + "\n");
            // Уведомляем всех клиентов о новом сообщении
            for (ClientGUI client : clients) {
                client.appendLog(login + ": " + message);
            }
        }
    }
}