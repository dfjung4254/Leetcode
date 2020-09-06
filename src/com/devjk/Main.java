package com.devjk;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_240 sol = new Solution_240();
        boolean ans = sol.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 6);

//        boolean ans = sol.searchMatrix(new int[][]{
//                {-1, 3}
//        }, 3);

        System.out.println(ans);

    }

}
