package com.devjk;

import java.util.ArrayList;
import java.util.List;

public class Solution_39 {

    private List<List<Integer>> ans;
    private int size;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ans = new ArrayList<>();
        size = candidates.length;
        bruteForce(candidates, target, 0, 0, new ArrayList<>());

        return ans;
    }

    public void bruteForce(int[] candidates, int target, int currentSum, int index, List<Integer> sub_answer){

        if(currentSum == target){
            /* find */
            /* for debug */
            System.out.println("Get Answer : ");
            for(Integer i : sub_answer){
                System.out.print(i + " ");
            }
            System.out.print('\n');
            /* end debug*/
            ans.add(new ArrayList<>(sub_answer));
            return;
        }

        if(currentSum > target){
            /* no ans */
            return;
        }


        for(int i = index; i < size; i++){
            sub_answer.add(candidates[i]);
            bruteForce(candidates, target, currentSum + candidates[i], i, sub_answer);
            sub_answer.remove(sub_answer.size() - 1);
        }

    }

}
