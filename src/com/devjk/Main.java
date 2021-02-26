package com.devjk;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_64_1 sol = new Solution_64_1();
        int ans = sol.minPathSum(new int[][] {
                {1,2,3}, {4,5,6}
        });
        System.out.println(ans);

    }

}
