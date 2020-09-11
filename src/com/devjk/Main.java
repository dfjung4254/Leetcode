package com.devjk;

import programmers.Carpet;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {
    
    public static void main(String[] args) throws IOException {

        Carpet carpet = new Carpet();
        int[] ans = carpet.solution(24, 24);
        System.out.println("ans :" + ans[0] + " / " + ans[1]);


    }

}
