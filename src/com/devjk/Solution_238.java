package com.devjk;

public class Solution_238 {

    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];
        int[] serve = new int[nums.length];

        serve[0] = 1;
        for(int i = 1; i < nums.length; i++){
            serve[i] = nums[i - 1] * serve[i - 1];
        }

        ans[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            ans[i] = nums[i + 1] * ans[i + 1];
            ans[i + 1] = ans[i + 1] * serve[i + 1];
        }

        for(int num : ans){
            System.out.print(num + " ");
        }
        System.out.println("");

        return ans;
    }

}
