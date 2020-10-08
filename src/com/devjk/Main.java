package com.devjk;

import programmers.OuterWallCheck_bruteForce;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        OuterWallCheck_bruteForce sol = new OuterWallCheck_bruteForce();
        int ans = sol.solution(12, new int[]{
                1, 5, 6, 10
        }, new int[]{
                1, 2, 3, 4
        });

        System.out.println("ans : " + ans);

    }

}
