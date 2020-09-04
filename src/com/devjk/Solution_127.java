package com.devjk;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        return bfs(beginWord, endWord, wordList);
    }

    public int bfs(String beginWord, String endWord, List<String> wordList){

        int ret = 0;

        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Pair(beginWord, 1));
        visited.add(beginWord);
        while(!q.isEmpty()){
            Pair curPair = q.poll();
            String curWord = curPair.word;
            int curWeight = curPair.weight;
            for(String word : wordList){
                if(isSimilar(curWord, word) && !visited.contains(word)){

                    if(endWord.equals(word)){
                        /* find minimum */
                        int weight = curWeight + 1;
                        if(ret == 0 || ret > weight){
                            ret = weight;
                        }
                    }
                    q.add(new Pair(word, curWeight + 1));
                    visited.add(word);
                }
            }
        }

        return ret;
    }

    public boolean isSimilar(String source, String target) {

        int diffCnt = 0;
        int size = source.length();
        for(int i = 0; i < size; i++){
            if(source.charAt(i) != target.charAt(i)){
                diffCnt++;
            }
        }

        return diffCnt == 1;
    }

    private class Pair {
        String word;
        int weight;
        public Pair(String word, int weight){
            this.word = word;
            this.weight = weight;
        }
    }

}
