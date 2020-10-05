package com.devjk;

import programmers.PillarAndBo;

import java.io.IOException;
import java.util.Arrays;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        PillarAndBo sol = new PillarAndBo();
        int[][] ans = sol.solution(5, new int[][]{
                {0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}
        });

        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }


    }

}
