package com.devjk.interviews.kakaoInterview2021_1;

import java.util.*;

public class kakao2021_1_2 {

    private Map<String, Integer> map;
    private Map<String, Integer> answerMap;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        map = new HashMap<>();
        answerMap = new HashMap<>();

        /* sort first */
        for(int i = 0; i < orders.length; i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for(int courseLength : course){
            for(int i = 0; i < orders.length; i++){
                bruteForce(orders, courseLength, 0, 0, new int[courseLength], i, orders[i].length());
            }
        }

        Set<String> set = map.keySet();
        for(String candidateCourse : set){
            if(map.get(candidateCourse) >= 2){
                answerMap.put(candidateCourse, map.get(candidateCourse));
            }
        }




        ArrayList<String> list = new ArrayList<>(answerMap.keySet());
        Collections.sort(list);

        String[] ans = new String[list.size()];
        int i = 0;
        for(String str : list){
            ans[i++] = str;
            System.out.println(str);
        }

        return ans;
    }

    private void bruteForce(String[] orders, int courseLength, int index, int cur, int[] candidate, int orderIndex, int curMax){

        if(index >= courseLength){
            /* init case */
            StringBuilder sb = new StringBuilder();
            for (int num : candidate) {
                sb.append(orders[orderIndex].charAt(num));
            }
            if(!map.containsKey(sb.toString())){
                /* init case */
                map.put(sb.toString(), 1);
            }else{
                int cnt = map.get(sb.toString());
                map.put(sb.toString(), cnt + 1);
            }
            System.out.println("map : " + sb.toString() + " / " + map.get(sb.toString()));

            return;
        }

        if(cur >= curMax){
            /* false */
            return;
        }

        candidate[index] = cur;
        bruteForce(orders, courseLength, index + 1, cur + 1, candidate, orderIndex, curMax);
        bruteForce(orders, courseLength, index, cur + 1, candidate, orderIndex, curMax);

    }

}
