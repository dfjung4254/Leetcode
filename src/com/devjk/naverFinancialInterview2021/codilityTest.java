package com.devjk.naverFinancialInterview2021;

import java.util.Arrays;

public class codilityTest {

  public int solution(int[] A) {
    // write your code in Java SE 8

    int ans = 1;
    Arrays.sort(A);
    for(int num : A) {
      if(num > ans) {
        break;
      }
      if(num == ans) {
        ans++;
      }
    }
    return ans;
  }

}
