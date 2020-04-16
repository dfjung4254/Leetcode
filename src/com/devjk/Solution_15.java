package com.devjk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {

    private List<List<Integer>> answer;

    public List<List<Integer>> threeSum(int[] nums) {

        answer = new ArrayList<>();
        Arrays.sort(nums);
        boolean init_i = true;
        int pre_i = 0;
        for(int i = 0; i < nums.length; i++){
            if(!init_i && pre_i == nums[i]) continue;
            init_i = false;
            pre_i = nums[i];
            boolean init_j = true;
            int pre_j = 0;
            for(int j = i + 1; j < nums.length; j++){
                if(!init_j && pre_j == nums[j]) continue;
                init_j = false;
                pre_j = nums[j];
                boolean init_k = true;
                int pre_k = 0;
                for(int k = j + 1; k < nums.length; k++){
                    if(!init_k && pre_k == nums[k]) continue;
                    init_k = false;
                    pre_k = nums[k];
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> addList = new ArrayList<>();
                        addList.add(nums[i]);
                        addList.add(nums[j]);
                        addList.add(nums[k]);
                        answer.add(addList);
                    }

                }
            }
        }

        return answer;
    }

}
