package com.devjk;

/*

    Solve with one-pass algorithm
    time complexity : O(N)

*/

public class Solution_134a {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int starting_station = 0;
        int total_gas = 0;
        int current_gas = 0;
        int size = gas.length;

        for(int i = 0; i < size; i++){

            total_gas += gas[i] - cost[i];
            current_gas += gas[i] - cost[i];
            if(current_gas < 0){
                starting_station = i + 1;
                current_gas = 0;
            }

        }
        if(total_gas < 0){
            starting_station = -1;
        }

        return starting_station;
    }

}
