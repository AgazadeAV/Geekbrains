package lecture_homework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    private JSpinner spFieldSize;
    private JRadioButton rbHumanVsAi;
    private JRadioButton rbHumanVsHuman;

    JButton btnStart = new JButton("Начать новую игру");

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Настройки игры");

        spFieldSize = new JSpinner(new SpinnerNumberModel(3, 3, 5, 1));

        rbHumanVsAi = new JRadioButton("Игрок против ИИ", true);
        rbHumanVsHuman = new JRadioButton("Игрок против Игрока");

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
        panel.add(new JLabel("Размер поля:"));
        panel.add(spFieldSize);
        panel.add(btnStart);
        panel.add(rbHumanVsAi);
        panel.add(rbHumanVsHuman);

        add(panel);
    }
}
