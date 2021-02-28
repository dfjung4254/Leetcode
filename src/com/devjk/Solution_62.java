package com.devjk;

public class Solution_62 {

  public int uniquePaths(int m, int n) {
    int[][] matrix = new int[m + 1][n + 1];
    matrix[0][1] = 1;
    return solveDP(matrix);
  }

  private int solveDP(int[][] matrix) {
    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j < matrix[i].length; j++) {
        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
      }
    }
    return matrix[matrix.length - 1][matrix[0].length - 1];
  }

}
