package com.devjk.naverFinancialInterview2021;

import java.util.HashSet;
import java.util.Set;

public class naver2021_3 {

  public int solution(int A, int B, int C, int D) {
    // write your code in Java SE 8
    return makeCase(new int[] {A, B, C, D},  0, 3, new HashSet<>());
  }

  private int makeCase(int[] numbers, int left, int right, Set<Integer> checkedCase) {

    if(left == right) {
      if(checkValidClock(numbers[0], numbers[1], numbers[2], numbers[3], checkedCase)){
        return 1;
      }
      return 0;
    }

    int availableCase = 0;
    for(int i = left; i <= right; i++) {
      swap(numbers, left, i);
      availableCase += makeCase(numbers, left + 1, right, checkedCase);
      swap(numbers, left, i);
    }

    return availableCase;
  }

  private boolean checkValidClock(int a, int b, int c, int d, Set<Integer> checkedCase) {
    StringBuilder strHour = new StringBuilder().append(a).append(b);
    StringBuilder strMinute = new StringBuilder().append(c).append(d);
    StringBuilder strTime = new StringBuilder().append(strHour).append(strMinute);
    int hour = Integer.parseInt(strHour.toString());
    int minute = Integer.parseInt(strMinute.toString());
    int time = Integer.parseInt(strTime.toString());
    if(hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && !checkedCase.contains(time)) {
      checkedCase.add(time);
      return true;
    }
    return false;
  }

  private void swap(int[] numbers, int i, int j) {
    int tmp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = tmp;
  }

}
