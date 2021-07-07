package com.devjk.interviews.startupCodingFestival2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class startup3 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    int size = Integer.parseInt(input);
    int[][] map = new int[size][size];
    int ans[] = new int[size];
    int total = 0;

    for(int i = 0; i < size; i++) {
      String line = br.readLine();
      for(int j = 0; j < size; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    for(int targetLength = 1; targetLength <= size; targetLength++) {
      for(int startI = 0; startI <= size - targetLength; startI++) {
        for(int startJ = 0; startJ <= size - targetLength; startJ++) {
          // i, j 시작점
          boolean isTrue = true;
          for(int i = startI; i < startI + targetLength; i++) {
            for(int j = startJ; j < startJ + targetLength; j++) {
              if(map[i][j] == 0) {
                isTrue = false;
                break;
              }
            }
            if(!isTrue) {
              break;
            }
          }
          if(isTrue) {
            ans[targetLength - 1]++;
            total++;
          }
        }
      }
    }
    System.out.println("total: " + total);
    for(int i = 0; i < size; i++) {
      if(ans[i] != 0) {
        System.out.println("size[" + (i + 1) + "]: " + ans[i]);
      }
    }

  }
}
