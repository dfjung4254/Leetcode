package com.devjk;

import java.util.HashSet;

public class Solution_41 {

    public int firstMissingPositive(int[] nums) {

        int ans = 0;
        int max = 0;

        HashSet<Integer> hashset = new HashSet<>();

        for(int num : nums){
            if(num <= 0){
                continue;
            }
            hashset.add(num);
            if(num > max){
                max = num;
            }
        }

        for(int i = 1; i < max; i++){
            if(!hashset.contains(i)){
                ans = i;
                break;
            }
        }

        if(ans == 0){
            ans = max + 1;
        }

        System.out.println(ans);
        return ans;
    }

}
