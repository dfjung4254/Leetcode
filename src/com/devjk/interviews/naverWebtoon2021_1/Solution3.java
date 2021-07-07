package com.devjk.interviews.naverWebtoon2021_1;

import java.util.regex.Pattern;

public class Solution3 {

  public int solution(String s, String t) {
    int result = 0;

    Pattern pattern = Pattern.compile(t);

    int index = 0;
    int tSize = t.length();
    while(true) {
      index = s.indexOf(t);

      if(index == -1) {
        break;
      }

      while(index != -1) {
        result++;
        index = s.indexOf(t, index + tSize);
      }

      s = pattern.matcher(s).replaceAll("");
    }

    return result;
  }

}
