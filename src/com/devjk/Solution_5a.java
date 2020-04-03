package com.devjk;

import java.util.HashMap;

public class Solution_5a {

    public String longestPalindrome(String s){

        String ans = "";
        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int size = s.length();

        if(size == 0){
            return "";
        }

        for(int strIdx = 0; strIdx < size; strIdx++){
            System.out.println("strIdx--" + strIdx);
            /* 홀수 */
            HashMap<String, Integer> oddValue = getMaxPalindromicValue(strIdx, strIdx, size, s);
            /* 짝수 */
            HashMap<String , Integer> evenValue = getMaxPalindromicValue(strIdx, strIdx + 1, size, s);

            HashMap<String, Integer> maxValue = (oddValue.get("Length") > evenValue.get("Length")) ? oddValue : evenValue;
            if(maxValue.get("Length") > maxLength){
                maxLength = maxValue.get("Length");
                maxLeft = maxValue.get("left");
                maxRight = maxValue.get("right");
            }
        }
        ans = s.substring(maxLeft, maxRight + 1);
        return ans;
    }

    public HashMap<String, Integer> getMaxPalindromicValue(int left, int right, int size, String str){
        while(isPalindromic(left, right, size, str)){
            left--;
            right++;
        }
        return setLengthIndexMap(left, right);
    }

    public HashMap<String, Integer> setLengthIndexMap(int left, int right){
        HashMap<String, Integer> retMap = new HashMap<>();
        retMap.put("Length", right - left - 1);
        retMap.put("left", left + 1);
        retMap.put("right", right - 1);
        return retMap;
    }

    public boolean isPalindromic(int left, int right, int size, String str){
        return (checkRange(left, right, size) && isEqualChar(str.charAt(left), str.charAt(right)));
    }

    public boolean checkRange(int left, int right, int size){
        return (left >= 0 && right < size);
    }

    public boolean isEqualChar(char ch1, char ch2){
        return (ch1 == ch2);
    }

}
