package com.devjk;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_773 sol = new Solution_773();
        int answer = sol.slidingPuzzle(new int[][]{
                {3,2,4},
                {1,5,0}
        });

        System.out.println(answer);

    }

}
