package tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final String TITLE = "Крестики-нолики";
    private static final String START_NEW_GAME = "Начать новую игру";
    private static final String EXIT = "Выйти";

    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;

    private final SettingsWindow settingsWindow;
    private final Map map;

    public GameWindow() {
        setTitle(TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        settingsWindow = new SettingsWindow(this);
        map = new Map();

        JButton btnStartGame = new JButton(START_NEW_GAME);
        JButton btnExit = new JButton(EXIT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnStartGame);
        panel.add(btnExit);

        add(panel, BorderLayout.SOUTH);
        add(map, BorderLayout.CENTER);

        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSize) {
        map.startNewGame(mode, fieldSize);
    }
}
