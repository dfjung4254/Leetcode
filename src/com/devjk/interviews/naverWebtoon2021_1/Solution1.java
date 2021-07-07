package com.devjk.interviews.naverWebtoon2021_1;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {

  public int solution(int[] prices, int[] discounts) {
    int answer = 0;

    Integer[] sortedPrices = Arrays.stream(prices)
            .boxed()
            .sorted(Collections.reverseOrder())
            .toArray(Integer[]::new);

    Integer[] sortedDiscounts = Arrays.stream(discounts)
            .boxed()
            .sorted(Collections.reverseOrder())
            .toArray(Integer[]::new);

    for(int i = 0; i < sortedPrices.length; i++) {

      int discountPercent = 100;
      if(i < sortedDiscounts.length) {
        discountPercent = 100 - sortedDiscounts[i];
      }

      answer += sortedPrices[i] / 100 * discountPercent;

    }

    return answer;
  }

}
