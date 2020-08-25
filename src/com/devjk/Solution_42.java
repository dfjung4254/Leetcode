package com.devjk;

/*

    42. Trapping Rain Water

    Two pointer solution

 */

public class Solution_42 {

    public int trap(int[] height) {

        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        boolean isTurnLeft = true;
        while(left <= right){
            if(isTurnLeft){
                /* left */
                if(height[left] < leftMax){
                    /* get water */
                    ans += leftMax - height[left];
                }else{
                    /* change turn */
                    leftMax = height[left];
                    isTurnLeft = (leftMax < rightMax);
                }
                left++;
            }else{
                /* right */
                if(height[right] < rightMax){
                    /* get water */
                    ans += rightMax - height[right];
                }else{
                    /* change turn */
                    rightMax = height[right];
                    isTurnLeft = isTurnLeft = (leftMax < rightMax);
                }
                right--;
            }
        }

        return ans;
    }

}
