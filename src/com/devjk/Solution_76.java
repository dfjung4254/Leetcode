package com.devjk;

import java.util.HashSet;
import java.util.Set;

public class Solution_76 {

    public String minWindow(String s, String t) {

        int left = 0;
        int right = 0;
        String answer = "";

        Set<Character> unused = new HashSet<>();
        Set<Character> used = new HashSet<>();
        for(char ch : t.toCharArray()){
            unused.add(ch);
        }

        int size = 0;
        while(left < size){

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if(used.add(rightChar)){
                used.remove(rightChar);
                unused.add(rightChar);
            }

            /* move right */
            while(right < size){
                char curChar = s.charAt(right);
                if(unused.contains(curChar)){
                    used.add(curChar);
                    unused.remove(curChar);
                }
                if(unused.isEmpty()){
                    break;
                }
                right++;
            }

            if(used.add(leftChar)){

            }

            while(left <= right){
                char curChar = s.charAt(left);
                if(unused.contains(curChar)){
                    used.add(curChar);
                    unused.remove(curChar);
                }
            }

        }

        return answer;
    }

}
