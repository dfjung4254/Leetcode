package programmers;

public class Thievery_dp {

    public int solution(int[] money) {

        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(dp[0], money[1]);
        for(int i = 2; i < dp.length - 1; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        dp[dp.length - 1] = dp[dp.length - 2];

        int[] dp1 = new int[money.length];
        dp1[0] = 0;
        dp1[1] = money[1];
        for(int i = 2; i < dp1.length; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        return Math.max(dp[dp.length - 1], dp1[dp1.length - 1]);
    }

}
