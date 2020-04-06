package com.devjk;

import java.util.ArrayList;
import java.util.List;

public class Solution_17 {

    private List<String> ans;
    private final char ALPH_MATCH[][] = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    private final char ALPH_SIZE[] = {
            0, 0, 3, 3, 3, 3, 3, 4, 3, 4
    };

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        int size = digits.length();
        int[] digitInteger = new int[size];
        if (size == 0) return ans;
        brute_force(digits, digitInteger, size, 0, 0);

        return ans;
    }

    public void brute_force(String digits, int[] digitIdx, int size, int index, int num) {

        if (index >= size) {
            /* end */
            saveThisCase(digits, digitIdx, size);
            return;
        }

        int indexSize = ALPH_SIZE[digits.charAt(index) - '0'];
        if (num >= indexSize) {
            return;
        }

        digitIdx[index] = num;
        brute_force(digits, digitIdx, size, index + 1, 0);
        brute_force(digits, digitIdx, size, index, num + 1);

    }

    public void saveThisCase(String digits, int[] digitIdx, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(ALPH_MATCH[digits.charAt(i) - '0'][digitIdx[i]]);
        }
        ans.add(sb.toString());
    }

}
