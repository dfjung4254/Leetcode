package com.devjk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sample_1 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Parse input */
        String line1 = br.readLine();
        String line2 = br.readLine();
        String[] str = line1.split(" ");
        int pos1 = Integer.parseInt(str[0]);
        int pos2 = Integer.parseInt(str[1]);
        str = line2.split(" ");
        int v = Integer.parseInt(str[0]);
        int a = Integer.parseInt(str[1]);
        int d = Integer.parseInt(str[2]);

        int diff = Math.max(pos1, pos2) - Math.min(pos1, pos2);
        int v2 = v + (a * diff);

        String ans = "0";
        if(v2 >= d){
            ans = "1";
        }

        System.out.println(ans);

    }

}
