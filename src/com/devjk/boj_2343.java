package com.devjk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2343 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        int[] trees = new int[input.length];
        for(int i = 0; i < trees.length; i++){
            trees[i] = Integer.parseInt(input[i]);
        }

        /*
            binary search
         */
        int left = 1;
        int right = 1000000001;
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            long calValue = 0;
            for(int i = 0; i < trees.length; i++){
                calValue += (mid > trees[i]) ? 0 : trees[i] - mid;
            }
            if(calValue >= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        System.out.println(right - 1);

    }

}
