package com.devjk;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_253 {

    public int minMeetingRooms(int[][] intervals) {

        int answer = 0;
        Arrays.sort(intervals, (intv1, intv2) -> {
            if(intv1[0] == intv2[0]){
                return intv1[1] - intv2[1];
            }
            return intv1[0] - intv2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cur_max = 0;
        for(int[] interval : intervals){
            if(pq.isEmpty() || pq.peek() > interval[0]){
                /* add new priority queue + size up - no empty room */
                answer++;
            }else{
                pq.poll();
            }
            pq.add(interval[1]);
            /*
                if is there empty room in priority queue?
                1. yes - get minimum max time room
                add pq.
                2. no - add new priority queue + size up
            */

        }
        System.out.println(answer);

        return answer;
    }

}
