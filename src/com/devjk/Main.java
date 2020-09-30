package com.devjk;

import programmers.WordPuzzle;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        WordPuzzle sol = new WordPuzzle();
        int ans = sol.solution(new String[]{
                "app", "ap", "p", "l", "e", "ple", "pp"
        }, "apple");
        System.out.println(ans);
    }

}
