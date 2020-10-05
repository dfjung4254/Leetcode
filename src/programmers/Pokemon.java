package programmers;

import java.util.HashSet;
import java.util.Set;

public class Pokemon {

    public int solution(int[] nums) {
        int answer = 0;

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int cnt = set.size();
        if(cnt < n / 2){
            answer = cnt;
        }else{
            answer = n / 2;
        }

        return answer;
    }

}
