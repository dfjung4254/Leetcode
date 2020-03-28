package com.devjk;

/*

    LeetCode Problem Solving
    1. Two Sum
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];

        int size = nums.length;
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                int val = nums[i] + nums[j];
                if(val == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }

}
