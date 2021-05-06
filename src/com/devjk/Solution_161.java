package com.devjk;

public class Solution_161 {

  private enum DIFF_CASE {
    INSERT, DELETE, REPLACE
  }

  public boolean isOneEditDistance(String s, String t) {
    return solveWithOnePass(s, t);
  }

  private boolean solveWithOnePass(String s, String t) {
    final int sSize = s.length();
    final int tSize = t.length();

    int insertCase = checkCount(s, t, sSize, tSize, DIFF_CASE.INSERT);
    int deleteCase = checkCount(s, t, sSize, tSize, DIFF_CASE.DELETE);
    int replaceCase = checkCount(s, t, sSize, tSize, DIFF_CASE.REPLACE);
    if(insertCase == 1 || deleteCase == 1 || replaceCase == 1) {
      return true;
    }

    return false;
  }

  private int checkCount(String s, String t, int sSize, int tSize, DIFF_CASE diffCase) {

    int passCount = 0;
    int sIdx = 0;
    int tIdx = 0;
    while(sIdx < sSize || tIdx < tSize) {

      char chS = sIdx < sSize ? s.charAt(sIdx) : ' ';
      char chT = tIdx < tSize ? t.charAt(tIdx) : ' ';

      if(chS != chT) {
        if(passCount >= 1) {
          passCount++;
          break;
        }
        passCount++;
        // insert 가정
        if(diffCase == DIFF_CASE.INSERT) {
          sIdx--;
        }else if(diffCase == DIFF_CASE.DELETE) {
          tIdx--;
        }
      }
      sIdx++;
      tIdx++;
    }
    return passCount;
  }

}
