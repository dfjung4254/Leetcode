package com.devjk;

public class Solution_79 {

  private final int DIRECTION[][] = {
          {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  public boolean exist(char[][] board, String word) {

    /* backtracking */
    boolean ans = false;
    int size = word.length();
    char initTarget = word.charAt(0);
    boolean[][] visited = new boolean[board.length][board[0].length];
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == initTarget){
          visited[i][j] = true;
          ans = solveBacktracking(i ,j, visited, board, word, 0, size);
          visited[i][j] = false;
        }
        if(ans) break;
      }
      if(ans) break;
    }
    return ans;
  }

  private boolean solveBacktracking(int i, int j, boolean[][] visited, char[][] board, String word, int index, int size) {

    if(index >= size - 1) {
      return true;
    }

    int nextTarget = word.charAt(index + 1);
    boolean ret = false;
    for(int dir = 0; dir < 4; dir++){
      int ni = i + DIRECTION[dir][0];
      int nj = j + DIRECTION[dir][1];
      if(isNoOut(ni, nj, board) && !visited[ni][nj] && board[ni][nj] == nextTarget){
        visited[ni][nj] = true;
        ret = solveBacktracking(ni, nj, visited, board, word, index + 1, size);
        visited[ni][nj] = false;
      }
      if(ret) break;
    }
    return ret;
  }

  private boolean isNoOut(int i, int j, char[][] board) {
    return(i >= 0 && i < board.length && j >= 0 && j < board[0].length);
  }

}
