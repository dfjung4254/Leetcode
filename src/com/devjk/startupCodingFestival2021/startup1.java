package com.devjk.startupCodingFestival2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class startup1 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String strNum = br.readLine();
    int num = Integer.parseInt(strNum);

    String minTime = "";
    String maxTime = "";

    while(num-- > 0) {
      String input = br.readLine();
      input = input.replaceAll("\\s", "");
      String[] times = input.split("~");

      if("".equals(minTime) || times[0].compareTo(minTime) > 0) {
        minTime = times[0];
      }
      if("".equals(maxTime) || times[1].compareTo(maxTime) < 0) {
        maxTime = times[1];
      }
    }

    if(minTime.compareTo(maxTime) > 0) {
      System.out.println("-1");
    }else{
      System.out.println(minTime + " ~ " + maxTime);
    }

  }

}
