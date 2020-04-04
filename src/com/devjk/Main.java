package com.devjk;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_542 sol = new Solution_542();
        int[][] tc = new int[][]{
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int[][] ret = sol.updateMatrix(tc);
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < ret[0].length; j++){
                System.out.print(ret[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
