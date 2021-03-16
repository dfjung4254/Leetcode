package com.devjk.naverFinancialInterview2021;

import java.util.HashMap;
import java.util.Map;

public class naver2021_1 {

  public int solution(String[] A) {
    // write your code in Java SE 8

    int ans = 0;
    Map<String, Integer> map = new HashMap<>();
    for(String department : A) {
      if(!map.containsKey(department)) {
        map.put(department, 0);
      }

      int count = map.get(department) + 1;
      map.put(department, count);

      if(count > ans) {
        ans = count;
      }

    }
    return ans;
  }

}
