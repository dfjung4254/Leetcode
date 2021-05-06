package com.devjk;

public class Solution_152 {

  public int maxProduct(int[] nums) {
    return solveWithDp(nums);
  }

  private int solveWithDp(int[] nums) {

    int answer = nums[0];
    int beforeMin = nums[0];
    int beforeMax = nums[0];

    for(int i = 1; i < nums.length; i++) {
      int nextMax = Math.max(nums[i], Math.max(beforeMax * nums[i], beforeMin * nums[i]));
      int nextMin = Math.min(nums[i], Math.min(beforeMax * nums[i], beforeMin * nums[i]));
      if(nextMax > answer) {
        answer = nextMax;
      }
      beforeMin = nextMin;
      beforeMax = nextMax;
    }

    return answer;
  }

}
