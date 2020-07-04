package com.devjk;

class Solution_45 {

    public int jump(int[] nums) {

        int ans = 0;
        int size = nums.length;
        int index = 0;
        while(index < size-1){
            /*
                1. 현재 인덱스에서 가지고 있는 숫자 만큼 다음 인덱스를 탐방한다.
                2. 다음 인덱스 의 값을 합쳐서 가장 많이 나아갈 수 있는 인덱스를 선택한다.
             */

            ans++;
            System.out.println("Current Index : " + index);

            int coverage = nums[index];
            int cov_size = index + coverage;
            int next = index;
            int max_cov = index;
            for(int i = 1; i <= coverage; i++){
                int next_index = index + i;
                if(next_index >= size - 1){
                    next = next_index;
                    break;
                }
                if(next_index < size){
                    int potential = getCoverage(next_index, nums);
                    if(max_cov < potential){
                        next = next_index;
                        max_cov = potential;
                    }
                }
            }
            index = next;
        }

        return ans;
    }

    public int getCoverage(int next_index, int[] nums){
        return next_index + nums[next_index];
    }

}