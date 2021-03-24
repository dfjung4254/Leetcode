package com.devjk.startupCodingFestival2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class startup5 {

  // right, left, down
  private static int[] dir_i = {0, 0, 1};
  private static int[] dir_j = {1, -1, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] nm = input.split(" ");
    int m = Integer.parseInt(nm[0]);
    int n = Integer.parseInt(nm[1]);
    char[][] map = new char[n][m];
    List<int[]> startLine = new ArrayList<>();
    int baseCount = -1;

    for(int i = 0; i < n; i++) {
      String line = br.readLine();
      for(int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j);
        if(map[i][j] == 'c') {
          startLine.add(new int[] {i, j});
        }
      }
    }

    for(int[] startPos : startLine) {
      int si = startPos[0];
      int sj = startPos[1];
      int[][] visited = new int[n][m];
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
          visited[i][j] = -1;
        }
      }
      visited[si][sj] = 0;
      Queue<int[]> q = new LinkedList<>();
      q.offer(new int[] {si, sj});
      while(!q.isEmpty()) {
        int[] curPos = q.poll();
        int ci = curPos[0];
        int cj = curPos[1];
        if(ci == n - 1) {
          if(baseCount == -1 || baseCount > visited[ci][cj]) {
            baseCount = visited[ci][cj];
          }
          break;
        }
        for(int dir = 0; dir < 3; dir++) {
          int ni = ci + dir_i[dir];
          int nj = cj + dir_j[dir];
          if(isAvailable(ni, nj, n, m) && visited[ni][nj] == -1 && map[ni][nj] != 'x') {
            int adder = (dir != 2) ? visited[ci][cj] + 1 : visited[ci][cj];
            visited[ni][nj] = adder;
            q.offer(new int[] {ni, nj});
          }
        }
      }

    }
    System.out.println(baseCount);
  }

  static boolean isAvailable (int i, int j, int n, int m) {
    return(i >= 0 && i < n && j >= 0 && j < m);
  }

}
