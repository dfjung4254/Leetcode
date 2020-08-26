package com.devjk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*

    Solution 126 : Word Ladder II

 */

public class Solution_126 {

    private int shortestLength;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        int size = wordList.size();
        String[] line = new String[size];
        line[0] = beginWord;
        shortestLength = size;

        dfs(ans, line, 0, endWord, wordList, new HashSet<>(), size);

        return ans;
    }

    public void dfs(List<List<String>> ans, String[] line, int index, String targetWord, List<String> wordList, HashSet<String> visited, int size){

        if(index >= size - 1){
            if(line[size - 1].equals(targetWord)){
                /* find answer */
                ans.add(new ArrayList<>(Arrays.asList(line)));
            }
            return;
        }

        String current = line[index];
        wordList.forEach(nextWord -> {
            if(!visited.contains(nextWord) && isSimillar(current, nextWord)){
                visited.add(nextWord);
                line[index + 1] = nextWord;
                dfs(ans, line, index + 1, targetWord, wordList, visited, size);
                visited.remove(nextWord);
            }
        });

    }

    private boolean allVisited(boolean[] visited){
        boolean ret = true;
        for(boolean v : visited){
            if(!v) ret = false;
        }
        return ret;
    }

}
