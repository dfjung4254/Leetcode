package com.devjk.interviews.kakaoMakers2021;

import java.util.HashSet;
import java.util.Set;

public class Kakao2021_2 {

  int answer = 0;

  public int solution(int[][] needs, int r) {

    // bruteforce
    int maxColumnSize = 0;
    for(int[] need : needs) {
      if(need.length > maxColumnSize) {
        maxColumnSize = need.length;
      }
    }

    // maxColumSize C r
    solve(maxColumnSize, r, 0, 0, new int[r], needs);
//    answer = solve(15, 8,0, 0, new int[8], needs);

    return answer;
  }

  private void solve(int n, int r, int index, int target, int[] map, int[][] needs) {

    if(index >= r) {
      // find case
      int cnt = count(needs, map);
      if(cnt > answer) {
        answer = cnt;
      }
      return;
    }

    if(target >= n) {
      return;
    }

    map[index] = target;
    solve(n, r, index + 1, target + 1, map, needs);
    solve(n, r, index, target + 1, map, needs);

  }

  private int count(int[][] needs, int[] map) {
    int cnt = 0;
    Set<Integer> set = new HashSet<>();
    for(int num : map) {
      set.add(num);
    }

    for(int[] need : needs) {
      boolean isMatch = true;
      for(int i = 0; i < need.length; i++) {
        if(need[i] == 1 && !set.contains(i)) {
          isMatch = false;
          break;
        }
      }
      if(isMatch) {
        cnt++;
      }
    }

    return cnt;
  }

}
