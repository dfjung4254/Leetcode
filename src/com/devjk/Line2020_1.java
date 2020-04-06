package com.devjk;

import java.util.Stack;

public class Line2020_1 {

    private Stack<Character> st1 = new Stack<>();
    private Stack<Character> st2 = new Stack<>();
    private Stack<Character> st3 = new Stack<>();
    private Stack<Character> st4 = new Stack<>();
    private int answer;

    public int solution(String inputString) {
        answer = 0;
        for(char ch : inputString.toCharArray()){
            if(ch == '('){
                st1.push(ch);
            }else if(ch == '{'){
                st2.push(ch);
            }else if(ch == '['){
                st3.push(ch);
            }else if(ch == '<'){
                st4.push(ch);
            }else if(ch == ')'){
                if(!checkStack1()) return -1;
            }else if(ch == '}'){
                if(!checkStack2()) return -1;
            }else if(ch == ']'){
                if(!checkStack3()) return -1;
            }else if(ch == '>'){
                if(!checkStack4()) return -1;
            }
        }
        if(!st1.isEmpty()) return -1;
        if(!st2.isEmpty()) return -1;
        if(!st3.isEmpty()) return -1;
        if(!st4.isEmpty()) return -1;

        return answer;
    }

    public boolean checkStack1(){
        if(st1.isEmpty()) return false;
        st1.pop();
        answer++;
        return true;
    }
    public boolean checkStack2(){
        if(st2.isEmpty()) return false;
        st2.pop();
        answer++;
        return true;
    }
    public boolean checkStack3(){
        if(st3.isEmpty()) return false;
        st3.pop();
        answer++;
        return true;
    }
    public boolean checkStack4(){
        if(st4.isEmpty()) return false;
        st4.pop();
        answer++;
        return true;
    }


}
