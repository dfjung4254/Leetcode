package com.devjk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_542 {

    private HashMap<String, Boolean> m;
    private int i_size;
    private int j_size;
    private int[][] matrix;
    private int[][] ans;
    private Queue<Integer[]> q;
    private final int[] DIR_I = {0, 1, 0, -1};
    private final int[] DIR_J = {1, 0, -1, 0};

    public int[][] updateMatrix(int[][] matrix) {
        q = new LinkedList<>();
        this.matrix = matrix;
        i_size = matrix.length;
        j_size = matrix[0].length;
        ans = new int[i_size][j_size];
        for (int i = 0; i < i_size; i++) {
            for (int j = 0; j < j_size; j++) {
                ans[i][j] = -1;
                if(matrix[i][j] == 0){
                    ans[i][j] = 0;
                    q.offer(new Integer[]{i, j});
                }
            }
        }
        bfs();
        return ans;
    }

    public boolean checkRange(int i, int j) {
        return (i >= 0 && i < i_size && j >= 0 && j < j_size);
    }

    public void bfs() {
        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nI = i + DIR_I[dir];
                int nJ = j + DIR_J[dir];
                if (checkRange(nI, nJ)) {
                    if(ans[nI][nJ] == -1){
                        ans[nI][nJ] = ans[i][j] + 1;
                        q.offer(new Integer[]{nI, nJ});
                    }else if(ans[nI][nJ] > ans[i][j] + 1){
                        ans[nI][nJ] = ans[i][j] + 1;
                        q.offer(new Integer[]{nI, nJ});
                    }
                }
            }
        }
    }

}
