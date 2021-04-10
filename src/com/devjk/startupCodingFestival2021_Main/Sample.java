package com.devjk.startupCodingFestival2021_Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sample {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] strNums = input.split(" ");
    int n = Integer.parseInt(strNums[0]);
    int k = Integer.parseInt(strNums[1]);

    input = br.readLine();
    String[] entries = input.split(" ");

    int ans = 0;
    int cnt = 1;
    for(int i = 0; i < n; i++) {
      if(cnt == 1) {
        ans++;
      }else if(cnt == k) {
        cnt = 0;
      }
      cnt++;
    }

    System.out.println(ans);

  }

}
