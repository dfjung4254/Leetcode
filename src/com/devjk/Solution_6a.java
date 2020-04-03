package com.devjk;

import java.util.ArrayList;

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
public class Solution_6a {

    /* TODO: String 대신 StringBuilder 와 StringBuffer 차이점 이해하고 활용해서 다시 풀어보기 */
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> stringBuildersList = new ArrayList<>();
        char[] charArray = s.toCharArray();

        for(int i = 0; i < numRows; i++){
            stringBuildersList.add(new StringBuilder());
        }

        int flag = 1;
        int index = 0;
        for(char curChar : charArray){
            stringBuildersList.get(index).append(curChar);
            flag = changeFlag(index, numRows, flag);
            index += flag;
        }

        StringBuilder ansBuilder = new StringBuilder();
        for(StringBuilder sb : stringBuildersList){
            ansBuilder.append(sb);
        }
        return ansBuilder.toString();
    }

    public int changeFlag(int index, int numRows, int flag){
        if(index == 0) flag = 1;
        if(index == numRows - 1) flag = -1;
        if(numRows == 1) flag = 0;
        return flag;
    }

}