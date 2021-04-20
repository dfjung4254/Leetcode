package com.devjk;

import java.util.LinkedList;
import java.util.List;

public class Solution_54 {

  // right, down, left, up
  private final int[] dir_i = {0, 1, 0, -1};
  private final int[] dir_j = {1, 0, -1, 0};

  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> list = new LinkedList<>();
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    visited[0][0] = true;
    list.add(matrix[0][0]);
    simulate(matrix, list, visited, 0, 0, 0);

    return list;
  }

  private void simulate(int[][] matrix, List<Integer> list, boolean[][] visited, int i, int j, int dir) {

    int ni = i + dir_i[dir];
    int nj = j + dir_j[dir];
    int tdir = (dir + 1) % 4;
    int ti = i + dir_i[tdir];
    int tj = j + dir_j[tdir];

    if(isValid(matrix, ni, nj, visited)) {
      visited[ni][nj] = true;
      list.add(matrix[ni][nj]);
      simulate(matrix, list, visited, ni, nj, dir);
    }else if(isValid(matrix, ti, tj, visited)) {
      visited[ti][tj] = true;
      list.add(matrix[ti][tj]);
      simulate(matrix, list, visited, ti, tj, tdir);
    }

  }

  private boolean isValid(int[][] matrix, int i, int j, boolean[][] visited) {
    int width = matrix[0].length;
    int height = matrix.length;
    return (i >= 0 && i < height && j >= 0 && j < width && !visited[i][j]);
  }

}
