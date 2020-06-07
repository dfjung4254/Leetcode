package com.devjk;

import java.util.Stack;

public class Solution_20 {

    private Stack<Character> stack;

    public boolean isValid(String s) {

        stack = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(!checkValidClose(ch)){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public boolean checkValidClose(char ch){
        boolean ret = false;
        if(!stack.isEmpty()){
            char top = stack.peek();
            if((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')){
                stack.pop();
                ret = true;
            }
        }
        return ret;
    }

}
