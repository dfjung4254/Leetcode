package com.devjk.interviews.kakaoInterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kakaoE2020_4 {

    /*
        Floyd-Warshall
     */

    private static int[][] matrix;
    private static final int INF = 987654321;

    public static void main(String[] args) throws Exception {

        matrix = new int[1000][1000];
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 1000; j++){
                if(i != j){
                    matrix[i][j] = INF;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] token = input.split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);
        for(int i = 0; i < m; i++){
            input = br.readLine();
            token = input.split(" ");
            int start = changeBinary(token[0]);
            int end = changeBinary(token[1]);
            int weight = Integer.parseInt(token[2]);
            matrix[start][end] = weight;
        }

        /* floyd-warshall */
        int size = (int) Math.pow(2, n);
        for(int k = 0; k < size; k++){
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(matrix[i][k] + matrix[k][j] < matrix[i][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        input = br.readLine();
        int q = Integer.parseInt(input);
        while(q-- > 0){
            input = br.readLine();
            token = input.split(" ");
            int start = changeBinary(token[0]);
            int end = changeBinary(token[1]);
            int minDist = (matrix[start][end] == INF) ? -1 : matrix[start][end];
            System.out.println(minDist);
        }


    }

    public static int changeBinary(String token){
        int size = token.length();
        char[] charToken = token.toCharArray();
        int ret = 0;
        for(int i = 0; i < size; i++){
            if(charToken[i] == 'o'){
                ret += Math.pow(2, i);
            }
        }
        return ret;
    }

}
