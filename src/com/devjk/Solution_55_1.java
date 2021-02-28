package com.devjk;

public class Solution_55_1 {

  public boolean canJump(int[] nums) {

    /* greedy */
    return solveGreedy(nums);
  }

  private boolean solveGreedy(int[] nums) {

    int lastIndex = nums.length - 1;
    int currentIndex = lastIndex;
    for(; currentIndex >= 0; currentIndex--) {
      if(currentIndex + nums[currentIndex] >= lastIndex) {
        lastIndex = currentIndex;
      }
    }

    return (lastIndex == 0);
  }

}
