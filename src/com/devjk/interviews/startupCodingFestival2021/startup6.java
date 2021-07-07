package com.devjk.interviews.startupCodingFestival2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class startup6 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] nm = input.split(" ");
    int m = Integer.parseInt(nm[0]);
    int n = Integer.parseInt(nm[1]);
    int[][] map = new int[n + 1][m + 1];
    int[][] dp = new int[n + 1][m + 1];

    for(int i = 1; i <= n; i++) {
      input = br.readLine();
      String[] nums = input.split(" ");
      for(int j = 1; j <= m; j++) {
        map[i][j] = Integer.parseInt(nums[j - 1]);
      }
    }

    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= m; j++) {
        int adder = Math.max(dp[i - 1][j], dp[i][j - 1]);
        dp[i][j] = map[i][j] + adder;
      }
    }

    System.out.println(dp[n][m]);
  }

}
