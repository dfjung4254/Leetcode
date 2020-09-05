package com.devjk;

import java.util.List;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_301 sol = new Solution_301();
        List<String> ans = sol.removeInvalidParentheses("()())()");
        for (String str : ans) {
            System.out.println(str);
        }

    }

}
