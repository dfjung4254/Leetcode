package com.devjk;

import java.util.HashMap;
import java.util.Map;

/*

    LeetCode Problem Solving
    3. Longest Substring Without Repeating Characters
    Given a string, find the length of the longest substring without repeating characters.

 */
public class Solution_3a {

    private int left = 0;
    private int right = -1;
    private int ans = 0;
    private Map<Character, Integer> map;

    public int lengthOfLongestSubstring(String s) {
        map = new HashMap<>();
        int size = s.length();
        while (++right < size) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            map.put(currentChar, right);
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

}
