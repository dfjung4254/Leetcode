package com.devjk;

/*

    LeetCode Problem Solving
    6. ZigZag Conversion
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:
    string convert(string s, int numRows);

 */
public class Solution_6 {

    private String strArray[];
    private String ans = "";

    public String convert(String s, int numRows) {
        strArray = new String[numRows];
        for(int i = 0; i < numRows; i++){
            strArray[i] = "";
        }
        int arrIdx = 0;
        int direction = 1;
        int size = s.length();
        for(int i = 0; i < size; i++){
            strArray[arrIdx] += String.valueOf(s.charAt(i));
            if(arrIdx == 0) direction = 1;
            if(arrIdx == numRows - 1) direction = -1;
            if(numRows == 1) direction = 0;
            arrIdx += direction;
        }
        for(int i = 0; i < numRows; i++){
            ans += strArray[i];
        }

        return ans;
    }

}
