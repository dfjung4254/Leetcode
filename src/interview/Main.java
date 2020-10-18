package interview;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        Solve1 sol = new Solve1();
        int[] ans = sol.solution(new int[]{1, 3, 5, 7, 9, 13, 15},
                new int[]{4, 5, 6, 8, 13},
                new int[]{5, 8, 13, 19});

        System.out.println(Arrays.toString(ans));

    }

}
