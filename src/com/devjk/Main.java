package com.devjk;

import programmers.FailRate;

import java.io.IOException;
import java.util.Arrays;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        FailRate sol = new FailRate();
        int[] ans = sol.solution(5, new int[]{
                2, 1, 2, 6, 2, 4, 3, 3
        });

        System.out.println(Arrays.toString(ans));

    }

}
