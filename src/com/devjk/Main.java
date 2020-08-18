package com.devjk;


import java.util.List;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_46 sol = new Solution_46();
        List<List<Integer>> ans = sol.permute(new int[]{1, 2, 3});
        for(List<Integer> list : ans){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

}
