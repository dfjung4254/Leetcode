package com.devjk;

import java.util.ArrayList;
import java.util.List;

/*

    Solution_51 : N-QUEENS problem

 */

public class Solution_51 {

    private final int[] DIR_I = {0, 1, 1, 1, 0, -1, -1, -1};
    private final int[] DIR_J = {1, 1, 0, -1, -1, -1, 0, 1};

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> answer = new ArrayList<>();
        boolean[][] map = new boolean[n][n];

        for(int i = 0; i < n; i++){
            map[0][i] = true;
            backTracking(answer, map, n, 1);
            map[0][i] = false;
        }

        return answer;
    }

    private void backTracking(List<List<String>> answer, boolean[][] map, int n, int index){

        if(index >= n){
            /* find available case */
            answer.add(makeList(map));
            for(int i = 0; i < index; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j]){
                        System.out.print(1 + " ");
                    }else{
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
            System.out.println("FIND ANSWER!");
            return;
        }

        for(int i = 0; i < index; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]){
                    System.out.print(1 + " ");
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

        for(int i = 0; i < n; i++){
            if(isEmptyHall(new int[] {index, i}, map)){
                map[index][i] = true;
                backTracking(answer, map, n, index + 1);
                System.out.println("----> backtrack");
                map[index][i] = false;
            }
        }

    }

    private boolean isEmptyHall(int[] point, boolean[][] map){

        for(int d = 0; d < 8; d++){
            int w = 0;
            int ni = point[0];
            int nj = point[1];
            while(isValid(ni, nj, map.length)){
                if(map[ni][nj]) return false;
                ni += DIR_I[d];
                nj += DIR_J[d];
            }
        }

        return true;
    }

    private boolean isValid(int i, int j, int length){
        return (i >= 0 && i < length && j >= 0 && j < length);
    }

    private List<String> makeList(boolean[][] map){

        List<String> list = new ArrayList<>();
        for(int i = 0; i < map.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < map[i].length; j++){
                char ch = (map[i][j]) ? 'Q' : '.';
                sb.append(ch);
            }
            list.add(sb.toString());
        }
        return list;
    }

}
