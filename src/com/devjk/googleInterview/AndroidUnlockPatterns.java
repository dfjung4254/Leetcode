package com.devjk.googleInterview;

/*

    Google Interview - Android Unlock Patterns
    Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
    count the total number of unlock patterns of the Android lock screen,
    which consist of minimum of m keys and maximum n keys.

    Rules for a valid pattern:
        Each pattern must connect at least m keys and at most n keys.
        All the keys must be distinct.
        If the line connecting two consecutive keys in the pattern passes through any other keys,
        the other keys must have previously selected in the pattern.
        No jumps through non selected key is allowed.
        The order of keys used matters.

    Explanation:
        | 1 | 2 | 3 |
        | 4 | 5 | 6 |
        | 7 | 8 | 9 |

    Invalid move: 4 - 1 - 3 - 6
    Line 1 - 3 passes through key 2 which had not been selected in the pattern.
    Invalid move: 4 - 1 - 9 - 2
    Line 1 - 9 passes through key 5 which had not been selected in the pattern.
    Valid move: 2 - 4 - 1 - 3 - 6
    Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
    Valid move: 6 - 5 - 4 - 1 - 9 - 2
    Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

    Example:
        Input: m = 1, n = 1
        Output: 9

 */
public class AndroidUnlockPatterns {

    private int ans;
    private final int[][] POS = {
            {-1, -1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
    };

    public int numberOfPatterns(int m, int n) {

        for(int length = m; length <= n; length++){
            for(int init = 1; init <= 9; init++){
                boolean visited[][] = new boolean[3][3];
                visited[POS[init][0]][POS[init][1]] = true;
                isValidPattern(visited, init, 1, length);
            }
        }

        return ans;
    }

    public void isValidPattern(boolean[][] visited, int target, int length, int max_length){

        if(length >= max_length){
            ans++;
            return;
        }

        /* find next candidate */
        for(int next = 1; next <= 9; next++){
            if(!visited[POS[next][0]][POS[next][1]] && isCrossOk(target, next, visited)){
                visited[POS[next][0]][POS[next][1]] = true;
                isValidPattern(visited, next, length+1, max_length);
                visited[POS[next][0]][POS[next][1]] = false;
            }
        }

    }

    boolean isCrossOk(int target, int next, boolean[][] visited){
        int ti = POS[target][0];
        int tj = POS[target][1];
        int ni = POS[next][0];
        int nj = POS[next][1];
        if(Math.abs(ti - ni) == 2){
            if(Math.abs(tj - nj) != 1){
                return visited[(ti+ni)/2][(tj+nj)/2];
            }
        }else if(Math.abs(tj - nj) == 2){
            if(Math.abs(ti-ni) != 1){
                return visited[(ti+ni)/2][(tj+nj)/2];
            }
        }
        return true;
    }

}
