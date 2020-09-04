package com.devjk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_773 {

    private final int[] DIR_I = {0, 1, 0, -1};
    private final int[] DIR_J = {1, 0, -1, 0};

    public int slidingPuzzle(int[][] board) {
        return bfs(board);
    }

    private int bfs(int[][] board) {

        int ret = -1;

        Queue<String[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        String strBoard = getBoardToString(board);

        /* cur board , moveCount */
        q.add(new String[]{strBoard, "0"});
        visited.add(strBoard);
        while (!q.isEmpty()) {
            String[] current = q.poll();
            String curStrBoard = current[0];
            int curMovCnt = Integer.parseInt(current[1]);

            if ("123450".equals(curStrBoard)) {
                ret = curMovCnt;
                break;
            }

            ArrayList<String> nextStrList = getNextCandidate(curStrBoard);

            for (String nextStrBoard : nextStrList) {
                if (!visited.contains(nextStrBoard)) {
                    q.add(new String[]{nextStrBoard, String.valueOf(curMovCnt + 1)});
                    visited.add(nextStrBoard);
                }
            }
        }

        return ret;
    }

    private String getBoardToString(int[][] board) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    private int[][] getStringToBoard(String strBoard) {

        int[][] ret = new int[2][3];

        int index = 0;
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < ret[0].length; j++){
                ret[i][j] = strBoard.charAt(index++) - '0';
            }
        }

        return ret;
    }

    private ArrayList<String> getNextCandidate(String strBoard) {

        ArrayList<String> ret = new ArrayList<>();

        int[][] board = getStringToBoard(strBoard);
        int zi = 0;
        int zj = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    /* find */
                    zi = i;
                    zj = j;
                    break;
                }
            }
        }

        for(int d = 0; d < 4; d++){
            int ni = zi + DIR_I[d];
            int nj = zj + DIR_J[d];
            if(isValid(ni, nj, board.length, board[0].length)){
                ret.add(getBoardToString(swapBoard(zi, zj, ni, nj, board)));
            }
        }

        return ret;
    }

    private int[][] swapBoard(int zi, int zj, int ni, int nj, int[][] board){

        int[][] ret = new int[2][3];

        for(int i = 0; i < ret.length; i++){
            ret[i] = board[i].clone();
        }

        int niNum = board[zi][zj];
        int ziNum = board[ni][nj];
        ret[zi][zj] = ziNum;
        ret[ni][nj] = niNum;

        return ret;
    }

    private boolean isValid(int i, int j, int height, int weight){
        return (i >= 0 && i < height && j >= 0 && j < weight);
    }

}
