package com.devjk;

public class Solution_5 {

    public String longestPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        String ans = "";
        int size = str.length();
        int maxLength = -1;

        for(int centerIdx = 0; centerIdx < size; centerIdx++){
            int weight = 0;
            int leftIdx = 0;
            int rightIdx = 0;
            int length = 0;
            /* 홀수 일 때 */
            while(checkIndex(centerIdx, centerIdx, weight, size)){
                leftIdx = centerIdx - weight;
                rightIdx = centerIdx + weight;
                if(str.charAt(leftIdx) != str.charAt(rightIdx)){
                    leftIdx++;
                    rightIdx--;
                    break;
                }
                weight++;
            }
            length = rightIdx - leftIdx + 1;
            System.out.println("홀 : " + str.substring(leftIdx, rightIdx + 1));
            if(length > maxLength){
                maxLength = length;
                ans = str.substring(leftIdx, rightIdx + 1);
            }

            weight = 0;
            leftIdx = 0;
            rightIdx = 0;
            length = 0;
            /* 짝수 일 때 */
            while(checkIndex(centerIdx, centerIdx + 1, weight, size)){
                leftIdx = centerIdx - weight;
                rightIdx = centerIdx + 1 + weight;
                if(str.charAt(leftIdx) != str.charAt(rightIdx)){
                    leftIdx++;
                    rightIdx--;
                    break;
                }
                weight++;
            }
            length = rightIdx - leftIdx + 1;
            if(length > maxLength){
                maxLength = length;
                ans = str.substring(leftIdx, rightIdx + 1);
            }
            System.out.println("짝 : " + str.substring(leftIdx, rightIdx + 1));
        }

        return ans;
    }

    public boolean checkIndex(int centerLeftIdx, int centerRightIdx, int weight, int size){
        boolean isSafe = true;
        if(centerRightIdx + weight >= size) isSafe = false;
        if(centerLeftIdx - weight < 0) isSafe = false;
        return isSafe;
    }

}
