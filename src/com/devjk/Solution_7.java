package com.devjk;

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
