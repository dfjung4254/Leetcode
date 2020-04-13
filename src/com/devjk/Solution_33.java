package com.devjk;

public class Solution_33 {

    public int search(int[] nums, int target) {

        int ans = binarySearch(nums, target);

        return ans;
    }

    public int binarySearch(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;
        int center = 0;
        while(left <= right){
            center = (left + right) / 2;
            if(nums[center] == target){
                return center;
            }else if(nums[center] > nums[left]){
                /* 순차 */
                if(target >= nums[left] && target < nums[center])
                    right = center - 1;
                else
                    left = center + 1;
            }else{
                /* 역순 */
                if(target <= nums[right] && target > nums[center])
                    left = center + 1;
                else
                    right = center - 1;
            }
        }

        return -1;
    }

}
