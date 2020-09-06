package com.devjk;

public class Solution_240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0){
            return false;
        }else if(matrix[0].length == 0){
            return false;
        }

        /* 4 binary searches */
        int candidateCol = getRowUpperBound(matrix, target, 0);
        System.out.println("candidateCol : " + candidateCol);
        int candidateRow = getColUpperBound(matrix, target, 0);
        System.out.println("candidateRow : " + candidateRow);

        int candidateColAns = getColUpperBound(matrix, target, candidateCol);
        System.out.println("candidateColAns : " + candidateColAns);
        int candidateRowAns = getRowUpperBound(matrix, target, candidateRow);
        System.out.println("candidateRowAns : " + candidateRowAns);

        return matrix[candidateColAns][candidateCol] == target || matrix[candidateCol][candidateRowAns] == target;

    }

    private int getRowUpperBound(int[][] matrix, int target, int row){

        int leftIdx = 0;
        int rightIdx = matrix[0].length - 1;
        int midIdx = 0;
        while(leftIdx < rightIdx){
            midIdx = (leftIdx + rightIdx) / 2;
            int val = matrix[row][midIdx];
//            System.out.println("DEBUG : " + val);
            if(val == target) {
                return midIdx;
            } else if(val < target){
                leftIdx = midIdx;
            }else {
                rightIdx = midIdx - 1;
            }

        }

        return leftIdx;
    }

    private int getColUpperBound(int[][] matrix, int target, int col){

        int topIdx = 0;
        int bottomIdx = matrix.length - 1;
        int midIdx = 0;
        while(topIdx <= bottomIdx){
            midIdx = (topIdx + bottomIdx) / 2;
            int val = matrix[midIdx][col];
//            System.out.println("DEBUG : " + val);
            if(val <= target){
                topIdx = midIdx;
            }else{
                bottomIdx = midIdx - 1;
            }
        }

        return topIdx;
    }

}
