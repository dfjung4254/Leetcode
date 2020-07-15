package com.devjk.challenge.july2020;

public class Week1_Island_Perimeter {

    private final int[] DIRECTION_I = {0, 1, 0, -1};
    private final int[] DIRECTION_J = {1, 0, -1, 0};
    private int width = 0;
    private int height = 0;

    public int islandPerimeter(int[][] grid) {

        int answer = 0;

        height = grid.length;
        width = grid[0].length;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1){
                    int adder = checkAdjacency(i, j, grid);
                    answer += adder;
                }
            }
        }

        return answer;
    }

    public int checkAdjacency(int i, int j, int[][] grid){
        int count = 4;
        for(int dir = 0; dir < 4; dir++){
            int next_i = i + DIRECTION_I[dir];
            int next_j = j + DIRECTION_J[dir];
            if(isValidDirection(next_i, next_j) && grid[next_i][next_j] == 1){
                count--;
            }
        }
        return count;
    }

    public boolean isValidDirection(int next_i, int next_j){
        return (next_i >= 0 && next_i < height && next_j >= 0 && next_j < width);
    }


}
