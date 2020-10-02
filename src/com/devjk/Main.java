package com.devjk;

import programmers.LittleFriendsSaCheonSung_simulate_advanced;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        LittleFriendsSaCheonSung_simulate_advanced sol = new LittleFriendsSaCheonSung_simulate_advanced();
        String ans = sol.solution(4, 4, new String[]{
                ".ZI.", "M.**", "MZU.", ".IU."
        });
        System.out.println("ans : " + ans);

    }

}
