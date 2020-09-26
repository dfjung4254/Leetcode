package programmers;

import java.util.Arrays;

public class Immigration_parametricSearch {

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long maxTime = times[times.length - 1];

        /* parametric search */
        long left = 0;
        long right = maxTime * n + 1;
        long mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            long cnt = getCnt(times, mid);
            if(cnt < n){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    private long getCnt(int[] times, long mid){

        long cnt = 0;

        for(int time : times){
            cnt += mid / time;
        }

        return cnt;
    }

}
