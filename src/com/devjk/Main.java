package com.devjk;

import programmers.DoublePriorityQueue_heap;

import java.io.IOException;
import java.util.Arrays;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        DoublePriorityQueue_heap sol = new DoublePriorityQueue_heap();
        int[] ans = sol.solution(new String[]{
                "I 7","I 5","I -5","D -1"
        });
        System.out.println(Arrays.toString(ans));

    }

}
