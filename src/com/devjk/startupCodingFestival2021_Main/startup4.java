package com.devjk.startupCodingFestival2021_Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class startup4 {

  public static void main(String[] args) throws Exception {

    // input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int size = Integer.parseInt(input);
    String[] dictionary = new String[size];
    for(int i = 0; i < size; i++) {
      dictionary[i] = br.readLine();
    }
    input = br.readLine();
    int qSize = Integer.parseInt(input);
    String[] queries = new String[qSize];
    for(int i = 0; i < qSize; i++) {
      queries[i] = br.readLine();
    }

    //solve
    for(String query : queries) {
      int cnt = 0;
      for(String word : dictionary) {
        if(patternSearch(query, word)){
          cnt++;
        }
      }
      System.out.println(cnt);
    }

  }


  // 출처
  // https://leetcode.com/problems/repeated-substring-pattern/discuss/565224/Java-or-.contains()-greater-69ms-or-KMP-pattern-match-greater-14ms
  static boolean patternSearch(String pattern, String text) {
    int patternLength = pattern.length();
    int textLength = text.length();
    int[] lps = new int[patternLength];
    prepareLPSArray(pattern, lps);

    int i = 0;
    int j = 0;
    while (i < textLength) {
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }

      if (j == patternLength) {
        return true;
      }

      if (i < textLength && text.charAt(i) != pattern.charAt(j)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }

    return false;
  }

  static void prepareLPSArray(String pattern, int lps[]) {
    int patternLength = pattern.length();
    int len = 0, i = 1;
    while (i < patternLength) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len == 0) {
          lps[i] = len;
          i++;
        } else {
          len = lps[len - 1];
        }
      }
    }
  }
}
