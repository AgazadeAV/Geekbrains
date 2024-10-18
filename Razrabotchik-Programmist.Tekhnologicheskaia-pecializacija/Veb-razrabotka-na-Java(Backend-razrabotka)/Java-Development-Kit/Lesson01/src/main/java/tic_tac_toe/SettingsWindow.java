package tic_tac_toe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final String START_NEW_GAME = "Начать новую игру";
    private static final String GAME_SETTINGS = "Настройки игры";
    private static final String PLAYER_VS_AI = "Игрок против ИИ";
    private static final String PLAYER_VS_PLAYER = "Игрок против Игрока";
    private static final String FIELD_SIZE = "Размер поля:";

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    private JSpinner spFieldSize;
    private JRadioButton rbHumanVsAi;
    private JRadioButton rbHumanVsHuman;

    JButton btnStart = new JButton(START_NEW_GAME);

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(GAME_SETTINGS);

        spFieldSize = new JSpinner(new SpinnerNumberModel(3, 3, 5, 1));

        rbHumanVsAi = new JRadioButton(PLAYER_VS_AI, true);
        rbHumanVsHuman = new JRadioButton(PLAYER_VS_PLAYER);

        ButtonGroup gameModeGroup = new ButtonGroup();
        gameModeGroup.add(rbHumanVsAi);
        gameModeGroup.add(rbHumanVsHuman);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode = rbHumanVsAi.isSelected() ? Map.MODE_HUMAN_VS_AI : Map.MODE_HUMAN_VS_HUMAN;
                int fieldSize = (int) spFieldSize.getValue();
                // Установка длины выигрыша равной размеру поля
                gameWindow.startNewGame(mode, fieldSize, fieldSize, fieldSize);
                setVisible(false);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel(FIELD_SIZE));
        panel.add(spFieldSize);
        panel.add(btnStart);
        panel.add(rbHumanVsAi);
        panel.add(rbHumanVsHuman);

        add(panel);
    }
}
