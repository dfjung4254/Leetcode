package com.devjk.interviews.lineInterview2020_1;

public class line2020_1 {

    private int[] count = new int[1000000];

    public int solution(int[][] boxes) {
        int answer = 0;
        int pairCnt = 0;

        for(int[] box : boxes){
            for(int i = 0; i < 2; i++){
                count[box[i]]++;
                if(count[box[i]] >= 2){
                    pairCnt++;
                    count[box[i]] = 0;
                }
            }
        }

        answer = boxes.length - pairCnt;

        System.out.println(answer);

        return answer;
    }

}
