package com.devjk;

import programmers.BlockGame_simulation;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BlockGame_simulation sol = new BlockGame_simulation();
        int ans = sol.solution(new int[][] {
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,4,0,0,0},
                        {0,0,0,0,0,4,4,0,0,0},
                        {0,0,0,0,3,0,4,0,0,0},
                        {0,0,0,2,3,0,0,0,5,5},
                        {1,2,2,2,3,3,0,0,0,5},
                        {1,1,1,0,0,0,0,0,0,5}
        });

        System.out.println("answer : " + ans);

    }

}
