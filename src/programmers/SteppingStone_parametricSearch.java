package programmers;

import java.util.Arrays;

public class SteppingStone_parametricSearch {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        /* parametric search */
        int left = 1;
        int right = distance + 1;
        int mid = 0;
        Arrays.sort(rocks);
        while(left < right){
            /* mid == min target */
            mid = (left + right) / 2;
            int usedNCnt = getUsedNCnt(rocks, mid);
            System.out.println(mid + " / " + usedNCnt);
            if(usedNCnt > n){
                /* 최소 만족 x */
                right = mid;
            }else{
                /* 최소 될 수 있음 */
                left = mid + 1;
            }
        }

        return left - 1;
    }

    private int getUsedNCnt(int[] rocks, int target){
        int cnt = 0;
        int pre_rock = 0;
        int rock = 0;
        for(int i = 0; i < rocks.length; i++){
            rock = rocks[i];
            int dist = rock - pre_rock;
            if(dist < target){
                cnt++;
            }else{
                pre_rock = rock;
            }
        }

        return cnt;
    }

}
