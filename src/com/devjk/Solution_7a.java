package com.devjk;

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
