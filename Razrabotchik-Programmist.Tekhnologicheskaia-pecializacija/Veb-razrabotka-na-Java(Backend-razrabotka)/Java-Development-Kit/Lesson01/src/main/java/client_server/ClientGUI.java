package client_server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();
    private final JList<String> userList = new JList<>();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField();
    private final JPasswordField tfPassword = new JPasswordField("05031995");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final ServerWindow serverWindow; // Ссылка на сервер

    public ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow; // Инициализируем ссылку на сервер
        serverWindow.addClient(this); // Регистрируем клиента на сервере

        // Запрос логина у пользователя
        String login = JOptionPane.showInputDialog("Введите ваш логин:");
        if (login == null || login.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Логин не может быть пустым. Приложение будет закрыто.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        tfLogin.setText(login); // Устанавливаем введенный логин в текстовое поле

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog, BorderLayout.CENTER);

        String[] users = {"User1", "User2", "User3", "User4", "User5"};
        userList.setListData(users);
        JScrollPane scrollUserList = new JScrollPane(userList);
        add(scrollUserList, BorderLayout.WEST);

        // Load chat history from file
        loadChatHistory();

        // Send message action
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Send message on Enter key press
        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    private void sendMessage() {
        String message = tfMessage.getText().trim();
        String login = tfLogin.getText(); // Получаем логин пользователя
        if (!message.isEmpty()) {
            serverWindow.receiveMessage(login, message); // Отправляем сообщение на сервер
            saveMessageToFile(login + ": " + message); // Сохраняем полное сообщение в файл
            tfMessage.setText("");
        }
    }

    public void appendLog(String message) {
        log.append(message + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    private void saveMessageToFile(String message) {
        try (FileWriter writer = new FileWriter("chat_history.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChatHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("chat_history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appendLog(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}