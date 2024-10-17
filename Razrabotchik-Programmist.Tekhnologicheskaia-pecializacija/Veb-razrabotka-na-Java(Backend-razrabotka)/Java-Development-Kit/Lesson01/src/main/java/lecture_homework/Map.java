package lecture_homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_HUMAN_VS_AI = 0;
    public static final int MODE_HUMAN_VS_HUMAN = 1;

    private static final int CELL_EMPTY = 0;
    private static final int CELL_X = 1;
    private static final int CELL_O = 2;

    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
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
                update(e);
            }
        });
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.mode = mode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;

        field = new int[fieldSizeY][fieldSizeX];
        gameOver = false;
        isHumanTurn = true;

        repaint();
    }

    private void update(MouseEvent e) {
        if (gameOver) return;

        int cellX = e.getX() / getCellWidth();
        int cellY = e.getY() / getCellHeight();

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;

        field[cellY][cellX] = isHumanTurn ? CELL_X : CELL_O;
        repaint();

        if (checkWin(isHumanTurn ? CELL_X : CELL_O)) {
            gameOver = true;
            // Измененные сообщения о победе для режима "Игрок против Игрока"
            String message = (mode == MODE_HUMAN_VS_HUMAN)
                    ? (isHumanTurn ? "Победил Игрок 1!" : "Победил Игрок 2!")
                    : (isHumanTurn ? "Человек победил!" : "Компьютер победил!");
            showGameOverMessage(message);
            return;
        }

        if (isFull()) {
            gameOver = true;
            showGameOverMessage("Ничья!");
            return;
        }

        isHumanTurn = !isHumanTurn;

        if (!isHumanTurn && mode == MODE_HUMAN_VS_AI) {
            aiTurn();
        }
    }

    private void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));

        field[y][x] = CELL_O;
        repaint();

        if (checkWin(CELL_O)) {
            gameOver = true;
            showGameOverMessage("Компьютер победил!");
        }

        if (isFull()) {
            gameOver = true;
            showGameOverMessage("Ничья!");
        }

        isHumanTurn = true;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == CELL_EMPTY;
    }

    private boolean isFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == CELL_EMPTY) return false;
            }
        }
        return true;
    }

    private boolean checkWin(int playerSymbol) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 1, 0, winLength, playerSymbol)) return true; // Проверка строки
                if (checkLine(x, y, 0, 1, winLength, playerSymbol)) return true; // Проверка колонки
                if (checkLine(x, y, 1, 1, winLength, playerSymbol)) return true; // Проверка диагонали \
                if (checkLine(x, y, 1, -1, winLength, playerSymbol)) return true; // Проверка диагонали /
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, int playerSymbol) {
        if (!isValidCell(x + (len - 1) * vx, y + (len - 1) * vy)) return false;

        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != playerSymbol) return false;
        }
        return true;
    }

    private void showGameOverMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (field == null) return;

        int cellWidth = getCellWidth();
        int cellHeight = getCellHeight();

        for (int i = 1; i < fieldSizeY; i++) {
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
        }
        for (int i = 1; i < fieldSizeX; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == CELL_X) {
                    drawX(g, x, y);
                } else if (field[y][x] == CELL_O) {
                    drawO(g, x, y);
                }
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
        return getWidth() / fieldSizeX;
    }

    private int getCellHeight() {
        return getHeight() / fieldSizeY;
    }
}
