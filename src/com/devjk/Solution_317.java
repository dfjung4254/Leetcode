package com.devjk;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_317 {

    private final int[] DIR_I = {1, 0, -1, 0};
    private final int[] DIR_J = {0, 1, 0, -1};

    public int shortestDistance(int[][] grid) {

        int answer = -1;

        int height = grid.length;
        int width = grid[0].length;
        int checkCount = getCheckCount(grid, height, width);

        System.out.println("checkCount : " + checkCount);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isCandidate(grid, i, j)) {
                    int weight = calculate(grid, i, j, checkCount);
                    System.out.println("check[" + i + "][" + j + "] : " + weight);
                    if (weight != -1 && (answer == -1 || answer > weight)) {
                        answer = weight;
                    }
                }
            }
        }

        return answer;
    }

    private int getCheckCount(int[][] grid, int height, int width){

        int cnt = 0;

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isCandidate(int[][] grid, int i, int j) {
        return (grid[i][j] == 0);
    }

    private int calculate(int[][] grid, int i, int j, int checkCount) {

        int ret = 0;
        int findCount = 0;

        Queue<Pair> q = new LinkedList<>();
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[height][width];
        q.add(new Pair(i, j, 0));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Pair curPair = q.poll();
            int cur_i = curPair.i;
            int cur_j = curPair.j;
            int cur_weight = curPair.weight;
            for (int dir = 0; dir < 4; dir++) {
                int next_i = cur_i + DIR_I[dir];
                int next_j = cur_j + DIR_J[dir];
                int next_weight = cur_weight + 1;
                if (isValid(grid, next_i, next_j, height, width) && !visited[next_i][next_j]) {
                    if (grid[next_i][next_j] == 1) {
                        /* find */
                        visited[next_i][next_j] = true;
                        ret += next_weight;
                        findCount++;
                    } else {
                        visited[next_i][next_j] = true;
                        q.add(new Pair(next_i, next_j, next_weight));
                    }
                }
            }
        }

        return (findCount == checkCount) ? ret : -1;
    }

    private boolean isValid(int[][] grid, int i, int j, int height, int width) {
        return (i >= 0 && i < height && j >= 0 && j < width && grid[i][j] != 2);
    }

    private class Pair {
        int i;
        int j;
        int weight;

        public Pair(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }

}
