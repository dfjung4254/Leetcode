package com.devjk.interviews.startupCodingFestival2021_Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class startup1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    String[] inputs = input.split(" ");
    int size = Integer.parseInt(inputs[0]);
    int targetTime = parseTime(inputs[1].split(":"));
    int[] times = new int[size];
    for(int i = 0; i < size; i++) {
      input = br.readLine();
      times[i] = parseTime(input.split(":"));
    }

    // solve - two pointer
    int left = 0;
    int right = 0;
    int sum = times[right];
    int ansCount = 0;
    int ansIndex = 0;
    while(right < size) {
      // check
      if(sum >= targetTime) {
        // count finished
        int cnt = right - left + 1;
        if(ansCount < cnt) {
          ansCount = cnt;
          ansIndex = left + 1;
        }
        // move left + 1
        sum -= times[left];
        left++;
        if(left > right) {
          right = left;
          if(right >= size) {
            break;
          }
          sum += times[right];
        }
      }else {
        // move right + 1
        right++;
        if(right >= size) {
          break;
        }
        sum += times[right];
      }
    }
    int cnt = right - left;
    if(ansCount < cnt) {
      ansCount = cnt;
      ansIndex = left + 1;
    }

    System.out.println(ansCount + " " + ansIndex);

  }

  private static int parseTime(String[] time) {
    int hour, minute, second;
    if(time.length == 3) {
      hour = Integer.parseInt(time[0]);
      minute = Integer.parseInt(time[1]);
      second = Integer.parseInt(time[2]);
    }else{
      hour = 0;
      minute = Integer.parseInt(time[0]);
      second = Integer.parseInt(time[1]);
    }
    return hour * 3600 + minute * 60 + second;
  }

}
