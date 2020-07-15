package com.devjk;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_56 {

    public int[][] merge(int[][] intervals) {

        /* Sort Array */
        Arrays.sort(intervals, (ival1, ival2) -> {
            if(ival1[0] == ival2[0]){
                return (ival1[1] - ival2[1]);
            }
            return (ival1[0] - ival2[0]);
        });

        /* get Max, Min */
        ArrayList<int[]> list = new ArrayList<>();
        int min = 0;
        int max = 0;
        boolean isFirst = true;
        int size = 0;
        for(int[] interval : intervals){
            int this_min = interval[0];
            int this_max = interval[1];
            if(isFirst || this_min > max){
                /* 분리 되어 있음 */
                isFirst = false;
                list.add(new int[]{this_min, this_max});
                size++;
                min = this_min;
                max = this_max;
            }else if(this_max > list.get(size-1)[1]){
                /* 겹침 - max 갱신 */
                int[] cur_interval = list.get(size - 1);
                cur_interval[1] = this_max;
                list.set(size - 1, cur_interval);
                max = this_max;
            }
        }

        int[][] answer = new int[size][2];
        for(int i = 0; i < size; i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        return answer;
    }

}
