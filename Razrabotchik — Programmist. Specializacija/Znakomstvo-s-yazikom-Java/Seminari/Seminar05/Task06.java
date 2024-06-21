/*Задание №6 (доп)
Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго
один раз. */

package Seminari.Seminar05;

public class Task06 {
    private static final int[] movesX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] movesY = {1, 2, 2, 1, -1, -2, -2, -1};
    private int[][] board;
    private int N;

    public Task06(int N) {
        this.N = N;
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
    }

    public boolean solve() {
        board[0][0] = 0; // Начинаем с верхнего левого угла
        if (!solveUtil(0, 0, 1)) {
            System.out.println("Error");
            return false;
        } else {
            printBoard();
            return true;
        }
    }

    private boolean solveUtil(int x, int y, int movei) {
        int nextX, nextY;
        if (movei == N * N) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            nextX = x + movesX[k];
            nextY = y + movesY[k];
            if (isSafe(nextX, nextY)) {
                board[nextX][nextY] = movei;
                if (solveUtil(nextX, nextY, movei + 1)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1; // Backtracking
                }
            }
        }

        return false;
    }

    private boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    private void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8; // Размер шахматной доски
        Task06 knightTour = new Task06(N);
        knightTour.solve();
    }
}
