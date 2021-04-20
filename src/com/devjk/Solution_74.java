package com.devjk;

public class Solution_74 {

  public boolean searchMatrix(int[][] matrix, int target) {

    int row = findRow(matrix, target);
    boolean isFind = findCol(matrix, target, row);

    return isFind;
  }

  private int findRow(int[][] matrix, int target) {

    int ret = 0;
    for(; ret < matrix.length; ret++) {
      if(ret == matrix.length - 1 || target < matrix[ret + 1][0]) {
        break;
      }
    }

    return ret;
  }

  private boolean findCol(int[][] matrix, int target, int row) {

    for(int i = 0; i < matrix[row].length; i++) {
      if(target == matrix[row][i]) {
        return true;
      }else if(target < matrix[row][i]) {
        break;
      }
    }

    return false;
  }

}
