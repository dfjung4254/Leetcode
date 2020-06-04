package com.devjk;

/*

    200. Number of Islands
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution_200 {

    private int ans;
    private int width;
    private int height;
    private final int[] DIR_I = {0, 1, 0, -1};
    private final int[] DIR_J = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {

        height = grid.length;
        if(height != 0) width = grid[0].length;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == '1'){
                    doBfs(grid, new int[]{i, j});
                    ans++;
                }
            }
        }

        return ans;
    }

    public void doBfs(char[][] grid, int[] pos){
        Queue<int[]> q = new LinkedList<>();

        q.add(pos);
        grid[pos[0]][pos[1]] = '0';
        while(!q.isEmpty()){
            int[] _pos = q.poll();
            int cur_i = _pos[0];
            int cur_j = _pos[1];
            for(int dir = 0; dir < 4; dir++){
                int next_i = cur_i + DIR_I[dir];
                int next_j = cur_j + DIR_J[dir];

                if(isValidPos(next_i, next_j) && grid[next_i][next_j] == '1'){
                    q.add(new int[]{next_i, next_j});
                    grid[next_i][next_j] = '0';
                }
            }
        }
    }

    public boolean isValidPos(int i, int j){
        return (i >= 0 && i < height && j >= 0 && j < width);
    }

}
