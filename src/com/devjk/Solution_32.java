package com.devjk;

import java.util.Stack;

public class Solution_32 {

  public int longestValidParentheses(String s) {
    return solveWithStack(s);
  }

  private int solveWithStack(String str) {

    int maxLength = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int size = str.length();
    for(int i = 0; i < size; i++) {
      if(str.charAt(i) == '(') {
        stack.push(i);
      }else {
        if(!stack.isEmpty()) {
          stack.pop();
          if(!stack.isEmpty()) {
            int length = i - stack.peek();
            maxLength = Math.max(length, maxLength);
          }else{
            stack.push(i);
          }
        }else {
          stack.push(i);
        }
      }
    }

    return maxLength;
  }

}
