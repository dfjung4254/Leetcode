package com.devjk.lineInterview2020_1;

import java.util.*;

public class line2020_2 {

    Set<Integer> holdList;
    Deque<Integer> dq;

    public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];

        holdList = new HashSet<>();
        dq = new ArrayDeque<>();
        for(int ballNum : ball){
            dq.offer(ballNum);
        }

        int idx = 0;
        for(int curOrder : order){

            if(!dq.isEmpty()){
                int first = dq.peekFirst();
                int last = dq.peekLast();
                if(first == curOrder){
                    int polled = dq.pollFirst();
                    answer[idx++] = polled;
                    while(!dq.isEmpty() && holdList.contains(dq.peekFirst())){
                        int p = dq.pollFirst();
                        answer[idx++] = p;
                        holdList.remove(p);
                    }
                }else if(last == curOrder){
                    int polled = dq.pollLast();
                    answer[idx++] = polled;
                    while(!dq.isEmpty() && holdList.contains(dq.peekLast())){
                        int p = dq.pollLast();
                        answer[idx++] = p;
                        holdList.remove(p);
                    }
                }else{
                    /* 보류 */
                    holdList.add(curOrder);
                }
            }
        }

        System.out.println("answer : " + Arrays.toString(answer));

        return answer;
    }

}
