package com.devjk.interviews.startupCodingFestival2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class startup4 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputScore = br.readLine();
    String[] inputScores = inputScore.split(" ");
    Map<Character, Integer> scores = new HashMap<>();
    scores.put('A', (int) (Double.parseDouble(inputScores[0]) * 10));
    scores.put('B', (int) (Double.parseDouble(inputScores[1]) * 10));
    scores.put('C', (int) (Double.parseDouble(inputScores[2]) * 10));
    scores.put('D', (int) (Double.parseDouble(inputScores[3]) * 10));
    scores.put('E', (int) (Double.parseDouble(inputScores[4]) * 10));

    Map<Character, Integer> state = new HashMap<>();
    state.put('W', 0);
    state.put('Y', 2);
    state.put('O', 1);

    String strNM = br.readLine();
    String[] nm = strNM.split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    int size = n * m;
    Contents[] contents = new Contents[size];
    int cnt = 0;
    for(int i = 0; i < n; i++) {
      String input = br.readLine();
      for(int j = 0; j < m; j++) {
        contents[cnt++] = new Contents(new int[] {i, j}, state.get(input.charAt(j)));
      }
    }

    cnt = 0;
    for(int i = 0; i < n; i++) {
      String input = br.readLine();
      for(int j = 0; j < m; j++) {
        contents[cnt++].setGenre(input.charAt(j));
      }
    }

    Arrays.sort(contents, new Comparator<Contents>() {
      @Override
      public int compare(Contents o1, Contents o2) {
        if(o1.getWatchState() == o2.getWatchState()) {
          return scores.get(o2.getGenre()) - scores.get(o1.getGenre());
        }else {
          return o2.getWatchState() - o1.getWatchState();
        }
      }
    });


    for(Contents content : contents) {
      if(content.getWatchState() != 0) {
        int score = scores.get(content.getGenre());
        int a = score / 10;
        int b = score % 10;
        System.out.println(content.getGenre() + " " + a + "." + b + " " + content.getPos()[0] + " " + content.getPos()[1]);
      }
    }

  }

  private static class Contents {
    private int watchState;
    private char genre;
    private int[] pos;
    Contents(int[] pos, int watchState) {
      this.pos = pos;
      this.watchState = watchState;
    }
    void setGenre(char genre) {
      this.genre = genre;
    }
    int getWatchState() {
      return watchState;
    }
    char getGenre() {
      return genre;
    }
    int[] getPos() {
      return pos;
    }
  }

}
