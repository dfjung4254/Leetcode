package com.devjk;

import java.util.*;

/*

    Solution 126 : Word Ladder II

    sample data : "hot","dot","dog","lot","log","cog"

 */

public class Solution_126 {

    private int minimumCount = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> answer = new ArrayList<>();

        bfs(answer, beginWord, endWord, wordList);

        printAnswer(answer);

        return answer;
    }

    private void printAnswer(List<List<String>> answer){
        answer.forEach(list -> {
            list.forEach(word -> {
                System.out.print(word + " ");
            });
            System.out.println("");
        });
    }

    private void bfs(List<List<String>> answer, String beginWord, String endWord, List<String> wordList){

        Queue<Pair> q = new LinkedList<>();
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        hashSet.add(beginWord);
        q.add(new Pair(hashSet, beginWord));

        while(!q.isEmpty()) {
            Pair currentPair = q.poll();
            LinkedHashSet<String> currentHashSet = currentPair.getHash();
            String currentLast = currentPair.getLast();

            //System.out.print(currentLast + " ");

            wordList.forEach(word -> {
                if (!currentHashSet.contains(word) && isSimilar(currentLast, word)) {
                    /* 도달했냐? 도달 안했으면 말없이 추가 */
                    if (word.equals(endWord)) {
                        int size = currentHashSet.size();
                        if (minimumCount == 0 || size == minimumCount) {
                            /* this is answer */
                            minimumCount = size;
                            currentHashSet.add(word);
                            setAnswer(answer, currentHashSet);
                        }
                    } else {
                        LinkedHashSet<String> hash = new LinkedHashSet<>(currentHashSet);
                        hash.add(word);
                        q.add(new Pair(hash, word));
                    }
                }
            });
        }
    }

    private void setAnswer(List<List<String>> answer, LinkedHashSet<String> hashSet){
        printLastAnswer(hashSet);
        answer.add(new ArrayList<>(hashSet));
    }

    private void printLastAnswer(LinkedHashSet<String> hashSet){
        hashSet.forEach(word -> {
            System.out.print(word + " ");
        });
        System.out.println("");
    }

    private class Pair{
        private LinkedHashSet<String> hash;
        private String last;
        public Pair(LinkedHashSet<String> hash, String last){
            this.hash = hash;
            this.last = last;
        }
        public void setHash(LinkedHashSet<String> hash) {this.hash = hash;}
        public LinkedHashSet<String> getHash() {return this.hash;}
        public void setLast(String last) {this.last = last;}
        public String getLast() {return this.last;}
    }

    private boolean isSimilar(String source, String target){
        int diffCount = 0;
        int size = source.length();
        for(int i = 0; i < size; i++){
            if(source.charAt(i) != target.charAt(i)){
                diffCount++;
            }
        }
        if(diffCount == 1){
            return true;
        }
        return false;
    }

}
