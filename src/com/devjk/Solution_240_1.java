package com.devjk;

public class Solution_240_1 {

  public boolean searchMatrix(int[][] matrix, int target) {

    for(int i = 0; i < matrix.length; i++) {
      if(matrix[i][0] <= target && binarySearch(matrix[i], target)) {
        return true;
      }else if(matrix[i][0] > target) {
        break;
      }
    }

    return false;
  }

  private boolean binarySearch(int[] row, int target) {

    int left = 0;
    int right = row.length;
    int mid;
    while(left < right) {
      mid = (left + right) / 2;
      if(row[mid] == target) {
        return true;
      }else if(row[mid] < target) {
        left = mid + 1;
      }else {
        right = mid;
      }
    }

    return false;
  }

}
