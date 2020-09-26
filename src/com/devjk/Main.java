package com.devjk;

import programmers.FarthestNode_Dijkstra;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        FarthestNode_Dijkstra sol = new FarthestNode_Dijkstra();
        sol.solution(6, new int[][]{
                /* [3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2] */
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        });

    }

}
