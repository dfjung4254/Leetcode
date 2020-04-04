package com.devjk;

public class Solution_37 {

    private boolean rowMem[][];
    private boolean colMem[][];
    private boolean gridMem[][];

    public void solveSudoku(char[][] board) {
        initMems();
        setMems(board);
        int weight = getNextIdx(board, 0);
        backTrackingSudoku(board, weight);
    }

    public boolean backTrackingSudoku(char[][] board, int index) {
        if (index > 80) {
            return true;
        }
        int row = index / 9;
        int col = index % 9;

        for (int num = 1; num < 10; num++) {
            if (checkNum(num, row, col)) {
                /* 현재 가능한 숫자 */
                setNum(board, num, row, col);
                int weight = getNextIdx(board, index);
                if (backTrackingSudoku(board, index + weight)) {
                    return true;
                } else {
                    releaseNum(board, num, row, col);
                }
            }
        }

        return false;
    }

    public int getNextIdx(char[][] board, int index) {
        int weight = 0;
        int row = (index + weight) / 9;
        int col = (index + weight) % 9;
        while ((index + weight) < 81 && board[row][col] != '.') {
            weight++;
            row = (index + weight) / 9;
            col = (index + weight) % 9;
        }

        return weight;
    }

    public void setNum(char[][] board, int num, int row, int col) {
        rowMem[row][num] = true;
        colMem[col][num] = true;
        gridMem[getGridIndex(row, col)][num] = true;
        board[row][col] = (char) (num + '0');
    }

    public void releaseNum(char[][] board, int num, int row, int col) {
        rowMem[row][num] = false;
        colMem[col][num] = false;
        gridMem[getGridIndex(row, col)][num] = false;
        board[row][col] = '.';
    }

    public boolean checkNum(int num, int row, int col) {
        /* row, col grid 모두 false 상태여야 한다 */
        if (rowMem[row][num] || colMem[col][num] || gridMem[getGridIndex(row, col)][num]) {
            return false;
        }
        return true;
    }

    public void initMems() {
        rowMem = new boolean[9][10];
        colMem = new boolean[9][10];
        gridMem = new boolean[9][10];
    }

    public void setMems(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowMem[i][board[i][j] - '0'] = true;
                    colMem[j][board[i][j] - '0'] = true;
                    gridMem[getGridIndex(i, j)][board[i][j] - '0'] = true;
                }
            }
        }
    }

    public int getGridIndex(int i, int j) {
        return (i / 3 * 3) + (j / 3);
    }

}
