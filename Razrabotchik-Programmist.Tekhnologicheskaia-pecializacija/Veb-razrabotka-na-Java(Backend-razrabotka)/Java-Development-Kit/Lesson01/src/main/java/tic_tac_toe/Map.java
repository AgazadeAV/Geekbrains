package tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final String PLAYER1_WIN = "Победил Игрок 1!";
    private static final String PLAYER2_WIN = "Победил Игрок 2!";
    private static final String HUMAN_WIN = "Человек победил!";
    private static final String AI_WIN = "Компьютер победил!";
    private static final String DRAW = "Ничья!";

    public static final int MODE_HUMAN_VS_AI = 0;
    public static final int MODE_HUMAN_VS_HUMAN = 1;

    private static final int CELL_EMPTY = 0;
    private static final int CELL_X = 1;
    private static final int CELL_O = 2;

    private int[][] field;
    private int fieldSize;
    private int winLength;

    private boolean gameOver;
    private boolean isHumanTurn;

    private int mode;
    private static final Random random = new Random();

    public Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (gameOver) return;
                int cellX = e.getX() / getCellWidth();
                int cellY = e.getY() / getCellHeight();
                if (isValidCell(cellX, cellY) && isEmptyCell(cellX, cellY)) {
                    field[cellY][cellX] = isHumanTurn ? CELL_X : CELL_O;
                    repaint();
                    checkEndConditions();
                    isHumanTurn = !isHumanTurn;
                    if (!isHumanTurn && mode == MODE_HUMAN_VS_AI) aiTurn();
                }
            }
        });
    }

    public void startNewGame(int mode, int fieldSize) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winLength = fieldSize;
        this.field = new int[fieldSize][fieldSize];
        this.gameOver = false;
        this.isHumanTurn = true;
        repaint();
    }

    private void checkEndConditions() {
        if (checkWin(isHumanTurn ? CELL_X : CELL_O)) {
            gameOver = true;
            showGameOverMessage(mode == MODE_HUMAN_VS_HUMAN ?
                    (isHumanTurn ? PLAYER1_WIN : PLAYER2_WIN) :
                    (isHumanTurn ? HUMAN_WIN : AI_WIN));
        } else if (isFull()) {
            gameOver = true;
            showGameOverMessage(DRAW);
        }
    }

    private void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        } while (!isEmptyCell(x, y));
        field[y][x] = CELL_O;
        repaint();
        checkEndConditions();
        isHumanTurn = true;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSize && y < fieldSize;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == CELL_EMPTY;
    }

    private boolean isFull() {
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == CELL_EMPTY) return false;
            }
        }
        return true;
    }

    private boolean checkWin(int playerSymbol) {
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (checkLine(x, y, 1, 0, winLength, playerSymbol) || // Проверка строки
                        checkLine(x, y, 0, 1, winLength, playerSymbol) || // Проверка колонки
                        checkLine(x, y, 1, 1, winLength, playerSymbol) || // Диагональ \
                        checkLine(x, y, 1, -1, winLength, playerSymbol)) { // Диагональ /
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, int playerSymbol) {
        for (int i = 0; i < len; i++) {
            if (!isValidCell(x + i * vx, y + i * vy) || field[y + i * vy][x + i * vx] != playerSymbol)
                return false;
        }
        return true;
    }

    private void showGameOverMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (field == null) return;
        int cellWidth = getCellWidth();
        int cellHeight = getCellHeight();
        for (int i = 1; i < fieldSize; i++) {
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
        }
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == CELL_X) drawX(g, x, y);
                else if (field[y][x] == CELL_O) drawO(g, x, y);
            }
        }
    }

    private void drawX(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.drawLine(x * getCellWidth(), y * getCellHeight(),
                (x + 1) * getCellWidth(), (y + 1) * getCellHeight());
        g.drawLine((x + 1) * getCellWidth(), y * getCellHeight(),
                x * getCellWidth(), (y + 1) * getCellHeight());
    }

    private void drawO(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.drawOval(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
    }

    private int getCellWidth() {
        return getWidth() / fieldSize;
    }

    private int getCellHeight() {
        return getHeight() / fieldSize;
    }
}
