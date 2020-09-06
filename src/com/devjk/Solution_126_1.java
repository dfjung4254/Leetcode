package com.devjk;

import java.util.*;

public class Solution_126_1 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> answer = new ArrayList<>();

        bfs(answer, beginWord, endWord, new HashSet<String>(wordList));

        answer.forEach(list -> {
            list.forEach(word -> {
                System.out.print(word + " ");
            });
            System.out.println();
        });

        return answer;
    }

    private void bfs(List<List<String>> answer, String beginWord, String endWord, Set<String> wordList){

        int min = 0;

        Queue<Pair> q = new LinkedList<>();
        LinkedHashSet<String> route = new LinkedHashSet<>();
        route.add(beginWord);
        q.offer(new Pair(route, beginWord));
        boolean isFind = false;
        while(!q.isEmpty()){
            Pair curRoute = q.poll();
            LinkedHashSet<String> curList = curRoute.list;
            String lastString = curRoute.lastString;

            if(endWord.equals(lastString) && (!isFind || min == curList.size())){
                /* find */
                answer.add(new ArrayList<>(curList));
                min = curList.size();
                isFind = true;
            }

            if(isFind){
                continue;
            }

            ArrayList<String> availableList = getAvailable(lastString, wordList);

            for(String word : availableList){
                if(!curList.contains(word)){
                    LinkedHashSet<String> nextList = new LinkedHashSet<>(curList);
                    nextList.add(word);
                    q.offer(new Pair(nextList, word));
                }
            }
        }

    }

    private ArrayList<String> getAvailable(String string, Set<String> wordList){

        int size = string.length();
        char[] chString = string.toCharArray();
        ArrayList<String> ret = new ArrayList<>();

        for(char ch = 'a'; ch <= 'z'; ch++){
            for(int i = 0; i < size; i++){
                if(ch == chString[i]) continue;
                char backup = chString[i];
                chString[i] = ch;
                if(wordList.contains(String.valueOf(chString))){
                    ret.add(String.valueOf(chString));
                }
                chString[i] = backup;
            }
        }

        return ret;
    }

    private class Pair{
        LinkedHashSet<String> list;
        String lastString;
        public Pair(LinkedHashSet<String> list, String lastString){
            this.list = list;
            this.lastString = lastString;
        }
    }

}
