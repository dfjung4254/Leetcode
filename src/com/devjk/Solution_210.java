package com.devjk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer> answer = new ArrayList<>();

        topologicalSort(answer, numCourses, prerequisites);

        int[] ret = new int[answer.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = answer.get(i);
            System.out.println(ret[i]);
        }

        if(answer.size() != numCourses){
            return new int[0];
        }

        return ret;
    }

    private void topologicalSort(ArrayList<Integer> answer, int numCourses, int[][] prerequisites){

        /*
            위상정렬
            1. inDegree 설정

         */
        /* set Pairs */
        Pair[] pairs = new Pair[numCourses];
        for(int i = 0; i < numCourses; i++){
            pairs[i] = new Pair(i, 0);
        }

        /* set inDegrees */
        for(int[] prr : prerequisites){
            pairs[prr[0]].inDegree++;
            pairs[prr[1]].next.add(prr[0]);
        }

        Queue<Pair> q = new LinkedList<>();
        for(Pair pair : pairs){
            if(pair.inDegree == 0){
                q.offer(pair);
            }
        }
        while(!q.isEmpty()){
            Pair curPair = q.poll();

            answer.add(curPair.index);

            for(int nextIndex : curPair.next){
                if(--pairs[nextIndex].inDegree == 0){
                    /* 다음 순서 */
                    q.offer(pairs[nextIndex]);
                }
            }

        }



    }

    private class Pair {
        int index;
        int inDegree;
        ArrayList<Integer> next;
        public Pair(int index, int inDegree){
            this.index = index;
            this.inDegree = inDegree;
            this.next = new ArrayList<>();
        }

    }

}
