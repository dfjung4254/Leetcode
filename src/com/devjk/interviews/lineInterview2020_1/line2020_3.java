package com.devjk.interviews.lineInterview2020_1;

import java.util.Arrays;

public class line2020_3 {

    public int[] solution(int n) {
        int[] answer = new int[2];
        answer[0] = -1;

        String strN = String.valueOf(n);

        bruteForce(answer, strN, 0);

        System.out.println("answer : " + Arrays.toString(answer));

        return answer;
    }

    private void bruteForce(int[] answer, String n, int plusCount){

        int size = n.length();

        if(size == 1){
            if(plusCount < answer[0] || answer[0] == -1){
                answer[0] = plusCount;
                answer[1] = Integer.parseInt(n);
            }
            return;
        }

        for(int i = 1; i < size; i++){
            int left = Integer.parseInt(n.substring(0, i));
            String strRight = n.substring(i);
            if(strRight.length() >= 2 && strRight.charAt(0) == '0'){
                continue;
            }
            int right = Integer.parseInt(strRight);
            int sum = left + right;
            bruteForce(answer, String.valueOf(sum), plusCount + 1);
        }

    }

}
