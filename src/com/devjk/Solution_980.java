package com.devjk;

public class Solution_980 {

    private int answer = 0;
    private final int[] DIR_I = {0, 1, 0, -1};
    private final int[] DIR_J = {1, 0, -1, 0};

    public int uniquePathsIII(int[][] grid) {

        int[] start = new int[2];
        int[] target = new int[2];

        /* find start and target */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        backTracking(grid, start);

        System.out.println(this.answer);

        return this.answer;
    }

    private void backTracking(int[][] grid, int[] pos) {

        int ci = pos[0];
        int cj = pos[1];

        if (grid[ci][cj] == 2) {
            if (checkAllCleared(grid)) {
                /* find anwer */
                this.answer++;
            }
            return;
        }

        grid[ci][cj] = 3;
        /* 유망한가 확인 */
        for (int d = 0; d < 4; d++) {
            int ni = ci + DIR_I[d];
            int nj = cj + DIR_J[d];
            if(isValid(ni, nj, grid.length, grid[0].length)
                && (grid[ni][nj] == 0 || grid[ni][nj] == 2)){
                backTracking(grid, new int[]{ni, nj});
            }
        }
        grid[ci][cj] = 0;

    }

    private boolean isValid(int i, int j, int height, int width){
        return (i >= 0 && i < height && j >= 0 && j < width);
    }

    private boolean checkAllCleared(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
