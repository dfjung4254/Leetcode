package com.devjk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    parametric search
    lower_bound
    upper_bound
 */

public class boj_1072 {

    public static void main(String[] args) throws IOException {

//        int z = (int)((47.0 / 53.0) * 100);

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        long z = (long)(((double) y * 100 / (double) x));

        long left = 0;
        long right = 1000000001;
        long mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            long px = x + mid;
            long py = y + mid;
            long pz = (long)(((double) py * 100 / (double) px));
            if(pz <= z){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        if(left == 1000000001){
            left = -1;
        }

        System.out.println(left);

    }

}
