package com.devjk;

/*

    46. Permutations

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        bruteforce(ans, nums, 0, nums.length);

        return ans;
    }

    public void bruteforce(List<List<Integer>> ans, int[] nums, int currentIndex, int size){

        if(isEndCase(currentIndex, size)){
            /* end */
            printNums(ans, nums);
            return;
        }

        for(int i = currentIndex; i < size; i++){
            swap(nums, currentIndex, i);
            bruteforce(ans, nums, currentIndex + 1, size);
            swap(nums, i, currentIndex);
        }

    }

    public void printNums(List<List<Integer>> ans, int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        ans.add(list);
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public boolean isEndCase(int currentIndex, int size){
        return (currentIndex >= size);
    }

    public boolean isOverCase(int currentNumber, int size){
        return (currentNumber >= size);
    }

}
