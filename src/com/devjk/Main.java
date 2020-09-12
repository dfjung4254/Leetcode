package com.devjk;

import com.devjk.kakaoInterview2021_1.kakao2021_1_3;

import java.io.IOException;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {
    
    public static void main(String[] args) throws IOException {

        kakao2021_1_3 sol = new kakao2021_1_3();
        sol.solution(new String[]{
                "java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"
        }, new String[]{
                "java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"
        });

    }

}
