package com.devjk.nhnInterview;

public class nhn2020_2 {

    public static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        /*
            1. 현재 맵에서 벽돌을 쌓는다.(오전)
            2. 현재 맵에서 시멘트를 부으며, 시멘트 개수를 세고, 벽돌을 채워준다
                - left dp, right dp 활용
         */
        int ans = 0;
        int[] map = new int[width];
        for(int[] blocksPerDay : blocks){
            setBlocks(map, blocksPerDay);
            ans += addSement(map);
        }

        System.out.println(ans);

    }

    private static void setBlocks(int[] map, int[] blocksPerDay){
        for(int i = 0; i < map.length; i++){
            map[i] += blocksPerDay[i];
        }
    }

    private static int addSement(int[] map){
        int sementCount = 0;
        int[] leftMax = new int[map.length];
        int[] rightMax = new int[map.length];
        /* DP 참고 출처 : Leetcode - trapping rain water */
        /* 양 끝은 시멘트 못 부음 */
        leftMax[0] = map[0];
        for(int i = 1; i < leftMax.length; i++){
            leftMax[i] = Math.max(leftMax[i - 1], map[i]);
        }
        rightMax[rightMax.length - 1] = map[map.length - 1];
        for(int i = rightMax.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], map[i]);
        }
        for(int i = 1; i < map.length - 1; i++){
            int newHeight = Math.min(leftMax[i], rightMax[i]);
            sementCount += newHeight - map[i];
            map[i] = newHeight;
        }
        return sementCount;
    }

}
