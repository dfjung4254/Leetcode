package com.devjk;

public class Solution_55 {

  public boolean canJump(int[] nums) {
    /* bruteForce */
    boolean[] visited = new boolean[nums.length];
    visited[0] = true;
    return solveBruteForce(nums, 0, visited);
  }

  private boolean solveBruteForce(int[] nums, int currentIndex, boolean[] visited) {

    int currentNumber = nums[currentIndex];
    int maxIndex = currentIndex + currentNumber;

    if(maxIndex >= nums.length - 1){
      return true;
    }

    for(int nextTargetIndex = currentIndex + 1; nextTargetIndex <= maxIndex; nextTargetIndex++) {
      if(!visited[nextTargetIndex]) {
        visited[nextTargetIndex] = true;
        if(solveBruteForce(nums, nextTargetIndex, visited)){
          return true;
        }
      }
    }

    return false;
  }

}
