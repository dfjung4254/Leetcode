package com.devjk;

public class Solution_11 {

    private int ans;
    private int right;
    private int left;
    private int size;

    public int maxArea(int[] height) {
        size = height.length;
        right = size -1;
        left = 0;
        ans = 0;
        while(checkIndex() && right > left){
            int area = getArea(height);
            ans = Math.max(ans, area);
            movePointer(height);
        }

        return ans;
    }

    public int getArea(int[] height){
        return (right - left) * Math.min(height[right], height[left]);
    }

    public void movePointer(int[] height){
        /*
            양쪽이 다르면 작은걸 옮긴다
            같으면 다음게 유효한지 확인하고 더 작은 것이 나올 때 까지 이동한다.
         */
        if(height[left] > height[right]){
            right--;
        }else if(height[left] < height[right]){
            left++;
        }else{
            moveUntilDiff(height);
        }
    }

    public void moveUntilDiff(int[] height){
        while(checkIndex() && height[right] == height[left]){
            if(right - 1 >= 0 && left + 1 < size && height[right - 1] > height[left + 1]){
                left++;
            }else{
                right--;
            }
        }
    }

    public boolean checkIndex(){
        return (right >= 0 && right < size && left >= 0 && left < size);
    }

}
