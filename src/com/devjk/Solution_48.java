package com.devjk;

/*

    48. Lotate Image
    You are given an n x n 2D matrix representing an image.
    Rotate the image by 90 degrees (clockwise).

    Note:
    You have to rotate the image in-place,
    which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.

 */

public class Solution_48 {

    public void rotate(int[][] matrix) {

        int size = matrix.length;
        int half_size = (size + 1) / 2;
        int max_j = size - 1;

        /* i 는 껍데기 차수, j는 각 차수의 라인 개수 */
        /* TODO : j 변수값 추가해야됨. */
        for(int i = 0; i < half_size; i++){
            for(int j = 0; j < max_j - i * 2; j++){

                int input = 0;
                int buffer = 0;

                /* up-right */
                input = matrix[i][i + j];
                buffer = matrix[i + j][size - 1 - i];
                matrix[i + j][size - 1 - i] = input;

                /* down-right */
                input = buffer;
                buffer = matrix[size - 1 - i][size - 1 - i - j];
                matrix[size - 1 - i][size - 1 - i - j] = input;

                /* down-left */
                input = buffer;
                buffer = matrix[size - 1 - i - j][i];
                matrix[size - 1 - i - j][i] = input;

                /* up-left */
                input = buffer;
                buffer = matrix[i][i + j];
                matrix[i][i + j] = input;

            }
        }

    }

}
