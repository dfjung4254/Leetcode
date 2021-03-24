package com.devjk.startupCodingFestival2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class startup2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    int size = Integer.parseInt(input);
    String tiles = br.readLine();
    long[] dp = new long[size];
    dp[0] = 1;
    dp[1] = tiles.charAt(1) == '1' ? 1 : 0;

    for(int i = 2; i < size; i++) {
      if(tiles.charAt(i) == '1') {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
    }

    System.out.println(dp[size - 1]);

  }

}
