package com.devjk;


import java.util.List;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_49 sol = new Solution_49();
        List<List<String>> list = sol.groupAnagrams(new String[]{""});
        for(List<String> ll : list){
            for(String str : ll){
                System.out.print(str + " / ");
            }
            System.out.println("");
        }

    }

}
