package com.devjk;

/*

    Solution_38. Count and Say

 */

public class Solution_12 {

    private final int[] INTEGERS = {
            1000, 500, 100, 50, 10, 5, 1
    };

    private final char[] ROMANS = {
            'M', 'D', 'C', 'L', 'X', 'V', 'I'
    };

    private final int ISNINE = 2;
    private final int ISFOUR = 1;
    private final int ISCOMMON = 0;

    public String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < INTEGERS.length; i++){

            num = divideNum(num, i, ans);
            System.out.println(ans.toString());
        }

        return ans.toString();
    }

    private int divideNum(int dividend, int index, StringBuilder ans){

        int divisor = INTEGERS[index];
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        int numberType = isCommonNumber(dividend, index);
        if(numberType == ISNINE){
            ans.append(ROMANS[index + 1]);
            ans.append(ROMANS[index - 1]);
            remainder = dividend % INTEGERS[index + 1];
        }else if(numberType == ISFOUR){
            ans.append(ROMANS[index + 1]);
            ans.append(ROMANS[index]);
            remainder = dividend % INTEGERS[index + 1];
        }else{
            while(quotient-- > 0){
                ans.append(ROMANS[index]);
            }
        }

        return remainder;
    }

    private int isCommonNumber(int num, int index){

        int ret = ISCOMMON;

        if(index % 2 == 1){
            int firstDigit = num / INTEGERS[index + 1];
            if(firstDigit == 9){
                ret = ISNINE;
            }else if(firstDigit == 4){
                ret = ISFOUR;
            }
        }

        System.out.println(num + " is : " + ret);

        return ret;
    }

}
