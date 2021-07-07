package com.devjk.interviews.startupCodingFestival2021_Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class startup2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    // input
    int size = Integer.parseInt(input);
    int index = 0;
    Map<String, Integer> checkMap = new HashMap<>();
    Line[] lines = new Line[size];
    for(int i = 0; i < size; i++) {
      input = br.readLine();
      String[] inputs = input.split(" ");
      if(!checkMap.containsKey(inputs[0])) {
        checkMap.put(inputs[0], index++);
      }
      if(!checkMap.containsKey(inputs[1])) {
        checkMap.put(inputs[1], index++);
      }
      lines[i] = new Line(checkMap.get(inputs[0]), checkMap.get(inputs[1]), Integer.parseInt(inputs[2]));
    }

    // solve - kruskal
    int ans = 0;
    int[] root = new int[index];
    for(int i = 0; i < index; i++) {
      root[i] = i;
    }
    Arrays.sort(lines, Comparator.comparingInt(o -> o.weight));
    for(Line line : lines) {
      int r1 = findRoot(root, line.src);
      int r2 = findRoot(root, line.dest);
      if(r1 != r2) {
        ans += line.weight;
        root[r1] = r2;
      }
    }
    System.out.println(ans);
  }

  private static int findRoot(int[] root, int i) {
    if(root[i] == i) {
      return root[i];
    }
    return root[i] = findRoot(root, root[i]);
  }

  private static class Line {
    int src;
    int dest;
    int weight;
    public Line(int src, int dest, int weight) {
      this.src = src;
      this.dest = dest;
      this.weight = weight;
    }
  }

}
