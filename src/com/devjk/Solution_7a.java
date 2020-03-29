package com.devjk;

/*

    LeetCode Problem Solving
    4. Reverse Integer
    Given a 32-bit signed integer, reverse digits of an integer.
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
    [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */
public class Solution_7a {

    private long ans;
    private boolean isMinus;

    public int reverse(int x) {

        if (x < 0) {
            isMinus = true;
            x = -x;
        }

        int size = (int) Math.log10(x);
        while (x > 0) {
            int num = x % 10;
            x /= 10;
            ans += (long) num * (long) Math.pow(10, size);
            size--;
        }

        if (ans > 2147483647){
            ans = 0;
        }

        if (isMinus) {
            ans = -ans;
        }

        return (int) ans;
    }

}
