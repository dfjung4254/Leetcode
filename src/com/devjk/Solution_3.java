package com.devjk;

import java.util.HashMap;
import java.util.Map;

/*

    LeetCode Problem Solving
    3. Longest Substring Without Repeating Characters
    Given a string, find the length of the longest substring without repeating characters.

 */
public class Solution_3 {

    private int ans;
    private int left;
    private int right = -1;
    private Map<Character, Integer> map;
    private char curChar;
    private char nextChar;
    String strVal;

    public Solution_3() {
        this.map = new HashMap();
    }

    public int lengthOfLongestSubstring(String s) {
        strVal = s;
        int size = strVal.length();

        while (right < size - 1) {
            nextChar = strVal.charAt(right + 1);
            procLeft(nextChar);
            right++;
            insertChar(right);
            getAnsLength();
        }

        return ans;
    }

    public void getAnsLength(){
        int gap = right - left + 1;
        if(gap > ans) ans = gap;
    }

    public void procLeft(char nextChar){
        if(map.containsKey(nextChar)){
            int subIdx = map.get(nextChar);
            delKeysUntilSubIdx(subIdx);
            left = subIdx + 1;
        }
    }

    public void delKeysUntilSubIdx(int subIdx){
        for(int i = left; i <= subIdx; i++){
            map.remove(strVal.charAt(i));
        }
    }

    public void insertChar(int idx){
        curChar = strVal.charAt(idx);
        map.put(curChar, idx);
    }
}
