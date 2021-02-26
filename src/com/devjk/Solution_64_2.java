package com.devjk;

public class Solution_64_2 {

  public int minPathSum(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    solveDp(dp, grid);
    return dp[grid.length - 1][grid[0].length - 1];
  }

  private void solveDp(int[][] dp, int[][] grid) {
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        int plusValue = 0;
        if(isNoOut(i - 1, j, dp) && isNoOut(i, j - 1, dp)){
          plusValue = Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
        if(isNoOut(i - 1, j, dp) && isOut(i, j - 1, dp)){
          plusValue = dp[i - 1][j];
        }
        if(isOut(i - 1, j, dp) && isNoOut(i, j - 1, dp)){
          plusValue = dp[i][j - 1];
        }
        dp[i][j] = grid[i][j] + plusValue;
      }
    }
  }

  private boolean isNoOut(int i, int j, int[][] grid) {
    int maxI = grid.length;
    int maxJ = grid[0].length;
    return (i < maxI && i >= 0 && j < maxJ && j >= 0);
  }

  private boolean isOut(int i, int j, int[][] grid) {
    return !isNoOut(i, j, grid);
  }

}
