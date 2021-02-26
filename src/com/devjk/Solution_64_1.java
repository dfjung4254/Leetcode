package com.devjk;

public class Solution_64_1 {

  private int min = 987654321;
  private final int DIRECTION[][] = new int[][] {
          {0, 1}, /* right */
          {1, 0}  /* down */
  };

  public int minPathSum(int[][] grid) {

    /* dfs - time exceed */
    /* 0, 0 to m, n */
    solveDfs(grid, new int[]{0, 0}, 0);

    return min;
  }

  private void solveDfs(int[][] grid, int[] currentIndex, int sum) {

    if(isEndPoint(grid, currentIndex)){
      sum += grid[currentIndex[0]][currentIndex[1]];
      if(sum < min) {
        min = sum;
      }
      return;
    }

    if(sum >= min) {
      return;
    }

    /* check edge */
    if(isOveredEdge(grid, currentIndex)){
      return;
    }

    sum += grid[currentIndex[0]][currentIndex[1]];
    for(int[] NEXTDIR : DIRECTION) {
      int plusI = NEXTDIR[0];
      int plusJ = NEXTDIR[1];
      int[] nextIndex = new int[]{currentIndex[0] + plusI, currentIndex[1] + plusJ};
      solveDfs(grid, nextIndex, sum);
    }

  }

  private boolean isEndPoint(int[][] grid, int[] currentIndex) {
    int i = grid.length;
    int j = grid[0].length;
    return (i - 1 == currentIndex[0] && j - 1 == currentIndex[1]);
  }

  private boolean isOveredEdge(int[][] grid, int[] currentIndex) {
    int i = grid.length;
    int j = grid[0].length;
    return (currentIndex[0] >= i || currentIndex[1] >= j);
  }


}
