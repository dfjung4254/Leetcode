package com.devjk;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {

    private List<String> ans;

    public List<String> generateParenthesis(int n) {

        ans = new ArrayList<>();
        String str = "";
        int open = 0;
        int close = 0;
        backtrack(n, str, open, close);

        return ans;
    }

    public void backtrack(int n, String str, int open, int close){

        if(str.length() == n * 2){
            ans.add(str);
            System.out.println(str);
            return;
        }

        if(open < n){
            backtrack(n, str + "(", open + 1, close);
        }
        if(open > close){
            backtrack(n, str + ")", open, close + 1);
        }

    }

}
