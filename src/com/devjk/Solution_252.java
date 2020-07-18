package com.devjk;

import java.util.Arrays;

public class Solution_252 {

    public boolean canAttendMeetings(int[][] intervals) {

        boolean answer = true;

        Arrays.sort(intervals, (itv1, itv2) -> {
            if(itv1[0] == itv2[0]){
                return (itv1[1] - itv2[1]);
            }
            return (itv1[0] - itv2[0]);
        });

        boolean isFirst = true;
        int cur_max = 0;
        for(int[] interval : intervals){
            if(isFirst){
                cur_max = interval[1];
                isFirst = false;
                continue;
            }
            if(interval[0] >= cur_max){
                /* seperated */
                cur_max = interval[1];
            }else{
                /* not seperated - return false */
                answer = false;
                break;
            }
        }
        System.out.println(answer);

        return answer;
    }

}
