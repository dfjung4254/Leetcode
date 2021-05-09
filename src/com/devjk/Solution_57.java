package com.devjk;

import java.util.ArrayList;
import java.util.List;

public class Solution_57 {

  public int[][] insert(int[][] intervals, int[] newInterval) {

    List<int[]> answer = new ArrayList<>();
    int[] mergingPart = newInterval;
    boolean isMergePartAdd = false;
    for(int[] interval : intervals) {
      // check is line overlapping
      if(isOverLapped(interval, newInterval)) {
        if(mergingPart[0] == newInterval[0]) {
          mergingPart[0] = Math.min(interval[0], newInterval[0]);
        }
        mergingPart[1] = Math.max(interval[1], newInterval[1]);
        continue;
      }
      if(!isMergePartAdd && interval[0] > newInterval[1]) {
        isMergePartAdd = true;
        answer.add(mergingPart);
      }
      answer.add(interval);
    }

    if(!isMergePartAdd) {
      answer.add(mergingPart);
    }

    return answer.toArray(new int[answer.size()][]);
  }

  private boolean isOverLapped(int[] lap1, int[] lap2) {
    if(lap1[1] >= lap2[0] && lap1[0] <= lap2[1]) {
      return true;
    }
    return false;
  }

}
