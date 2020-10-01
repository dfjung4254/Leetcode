package com.devjk;

import programmers.MovingBlock_bfs_expert;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        MovingBlock_bfs_expert sol = new MovingBlock_bfs_expert();
        int ans = sol.solution(new int[][]{
                {0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}
        });

        System.out.println("answer : " + ans);

    }

}
