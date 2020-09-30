package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordPuzzle {

    private int answer;

    public int solution(String[] strs, String target) {
        answer = -1;

        Set<String> hash = new HashSet<>(Arrays.asList(strs));

        /* dynamic programming */
        int targetSize = target.length();
        int[] dp = new int[targetSize + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = targetSize;
        }
        for(int i = 1; i < dp.length; i++){
            int min = 0;
            for(int j = 0; j < i; j++){
                String subTarget = target.substring(j, i);
                if(hash.contains(subTarget)){
                    if(dp[i] > dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        if(dp[dp.length - 1] == targetSize){
            answer = -1;
        }else{
            answer = dp[dp.length - 1];
        }

        return answer;
    }

}
