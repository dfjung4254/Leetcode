package com.devjk;

/*

    LeetCode Problem Solving
    4. Reverse Integer
    Given a 32-bit signed integer, reverse digits of an integer.
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
    [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */
public class Solution_7 {

    private int ans;
    private boolean isMinus;

    public int reverse(int x) {

        if (x < 0) {
            isMinus = true;
            x = -x;
        }

        try {
            String strNum = String.valueOf(x);
            String strAns = "";
            int size = strNum.length();
            for (int i = size - 1; i >= 0; i--) {
                strAns += Integer.parseInt(String.valueOf(strNum.charAt(i)));
            }
            ans = Integer.parseInt(strAns);

            if (isMinus) {
                ans = -ans;
            }
        } catch (NumberFormatException e) {
            ans = 0;
        }

        return ans;
    }
}
