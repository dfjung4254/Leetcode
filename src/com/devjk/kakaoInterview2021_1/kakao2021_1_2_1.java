package com.devjk.kakaoInterview2021_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class kakao2021_1_2_1 {

    private HashMap<String, Integer>[] maps;

    public String[] solution(String[] orders, int[] course) {

        ArrayList<String> list = new ArrayList<>();

        maps = new HashMap[course.length];
        for(int i = 0; i < maps.length; i++){
            maps[i] = new HashMap<>();
        }

        /* sort first */
        for(int i = 0; i < orders.length; i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for(int courseIdx = 0; courseIdx < course.length; courseIdx++){
            int courseLength = course[courseIdx];
            for(int i = 0; i < orders.length; i++){
                bruteForce(orders, courseLength, 0, 0, new int[courseLength], i, orders[i].length(), courseIdx);
            }
        }

        for(HashMap<String, Integer> map : maps){

            ArrayList<String> arr = new ArrayList<>();
            int maxCnt = 0;

            for(String key : map.keySet()){
                if(map.get(key) == maxCnt){
                    arr.add(key);
                }else if(map.get(key) > maxCnt){
                    arr.clear();
                    maxCnt = map.get(key);
                    arr.add(key);
                }
            }
            if(maxCnt >= 2){
                list.addAll(arr);
            }
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    private void bruteForce(String[] orders, int courseLength, int index, int cur, int[] candidate, int orderIndex, int curMax, int courseIdx){

        if(index >= courseLength){
            /* init case */
            StringBuilder sb = new StringBuilder();
            for (int num : candidate) {
                sb.append(orders[orderIndex].charAt(num));
            }
            String strKey = sb.toString();
            if(!maps[courseIdx].containsKey(strKey)){
                maps[courseIdx].put(strKey, 1);
            }else{
                int cnt = maps[courseIdx].get(strKey);
                maps[courseIdx].put(strKey, cnt + 1);
            }

            return;
        }

        if(cur >= curMax){
            /* false */
            return;
        }

        candidate[index] = cur;
        bruteForce(orders, courseLength, index + 1, cur + 1, candidate, orderIndex, curMax, courseIdx);
        bruteForce(orders, courseLength, index, cur + 1, candidate, orderIndex, curMax, courseIdx);

    }

}
