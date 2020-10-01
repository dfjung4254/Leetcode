package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordPuzzle_dp {

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
            StringBuilder sb = new StringBuilder();
            for(int j = i - 1; j >= i - 5 && j >= 0; j--){
                sb.insert(0, target.charAt(j));
                if(hash.contains(sb.toString())){
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
