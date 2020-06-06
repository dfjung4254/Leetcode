package com.devjk.kakaoInterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kakaoE2020_1 {

    private static final int SMALL = 0;
    private static final int CAPITAL = 1;
    private static final int NUM = 2;
    private static final int SPECIAL = 3;
    private static final int LENGTH = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean[] kind = new boolean[5];
        int length = input.length();
        if(length >= 10) kind[LENGTH] = true;
        for(char ch : input.toCharArray()){

            if(isSmall(ch)){
                kind[SMALL] = true;
            }else if(isCapital(ch)){
                kind[CAPITAL] = true;
            }else if(isNum(ch)){
                kind[NUM] = true;
            }else{
                kind[SPECIAL] = true;
            }

        }

        int ans = 0;
        for(boolean isLevelUp : kind){
            if(isLevelUp) ans++;
        }
        System.out.println("LEVEL"+ans);
    }

    public static boolean isSmall(char ch){
        return (ch >= 'a' && ch <= 'z');
    }

    public static boolean isCapital(char ch){
        return (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isNum(char ch){
        return (ch >= '0' && ch <= '9');
    }

}
