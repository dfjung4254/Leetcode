package com.devjk;

public class Main {

    Solution sol;

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] ans = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");

    }
}
