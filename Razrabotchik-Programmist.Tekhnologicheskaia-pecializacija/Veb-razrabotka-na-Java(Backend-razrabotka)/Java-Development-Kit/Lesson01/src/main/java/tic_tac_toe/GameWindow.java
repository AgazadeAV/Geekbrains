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
    private final Map gameMap;

    public GameWindow() {
        setTitle(TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gameMap = new Map();
        settingsWindow = new SettingsWindow(this);

        JButton btnStart = new JButton(START_NEW_GAME);
        JButton btnExit = new JButton(EXIT);

        btnStart.addActionListener(new ActionListener() {
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

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnStart);
        panel.add(btnExit);

        add(panel, BorderLayout.SOUTH);
        add(gameMap, BorderLayout.CENTER);

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}
