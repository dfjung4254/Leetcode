package com.devjk;

import java.util.*;

public class Solution_301 {

    public List<String> removeInvalidParentheses(String s) {

        List<String> answer = new ArrayList<>();
        bfs(answer, s);

        return answer;
    }

    private void bfs(List<String> list, String str){

        int minimum = -1;

        /* String / Weight */
        Queue<String[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();



        q.add(new String[]{str, String.valueOf(0)});
        visited.add(str);
        while(!q.isEmpty()){
            String[] current = q.poll();
            String curStr = current[0];
            int curWeight = Integer.parseInt(current[1]);

            if(isParentheses(curStr) && (minimum == -1 || minimum >= curWeight)){
                /* add answer list */
                minimum = curWeight;
                list.add(curStr);
            }

            int size = curStr.length();
            for(int i = 0; i < size; i++){
                String nextStr = new StringBuffer(curStr).deleteCharAt(i).toString();
                if(!visited.contains(nextStr)){
                    q.add(new String[]{nextStr, String.valueOf(curWeight + 1)});
                    visited.add(nextStr);
                }
            }
        }
    }

    private boolean isParentheses(String str){

        int st = 0;
        for(char ch : str.toCharArray()){
            if(ch == '('){
                st++;
            }else if(ch == ')'){
                if(st <= 0) return false;
                st--;
            }
        }

        return st == 0;
    }

}
