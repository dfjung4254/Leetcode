package com.devjk;

public class Solution_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int ans = -1;
        int size = gas.length;
        for(int i = 0; i < size; i++){
            /* find gas */
            if(isWayExist(i, gas, cost, size)){
                ans = i;
                break;
            }
        }

        return ans;
    }

    public boolean isWayExist(int index, int[] gas, int[] cost, int size){
        boolean ret = false;

        int remain_gas = 0;
        int current_index = index;
        boolean isStart = true;
        while(true){

            System.out.println("Current Status---------");
            System.out.println("remain_gas : " + remain_gas);
            System.out.println("current_index : " + current_index);
            System.out.println("-----------------------");

            if(!isStart && current_index == index){
                ret = true;
                break;
            }
            isStart = false;
            remain_gas = fullfillGas(remain_gas, current_index, gas);
            remain_gas -= cost[current_index];
            if(remain_gas < 0){
                ret = false;
                break;
            }
            current_index = getNextIdx(current_index, size);
        }

        return ret;
    }

    public int fullfillGas(int remain_gas, int current_index, int[] gas){
        return (remain_gas + gas[current_index]);
    }

    public int getNextIdx(int index, int size){
        return ((index + 1) % size);
    }

}
