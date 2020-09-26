package com.devjk;

import programmers.BadUser;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BadUser sol = new BadUser();
        sol.solution(new String[]{
                "frodo", "fradi", "crodo", "abc123", "frodoc"
        }, new String[]{
                "*rodo", "*rodo", "******"
        });

    }

}
