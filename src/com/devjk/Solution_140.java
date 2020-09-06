package com.devjk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> answer = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(wordDict);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        backTracking(answer, s, dictionary, 0, list, s.length());

        return answer;
    }

    private void backTracking(List<String> answer, String string, Set<String> dictionary, int index, List<Integer> list, int size){

        if(index >= size){
            /* find answer */

            StringBuilder sb = new StringBuilder();
            int beforeIdx = list.get(0);
            int lSize = list.size();
            for(int i = 1; i < lSize; i++){
                String cut = string.substring(beforeIdx, list.get(i));
                beforeIdx = list.get(i);
                sb.append(cut).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            answer.add(sb.toString());

            return;
        }

        for(int i = index + 1; i <= size; i++){
            String candidateWord = string.substring(index, i);
            if(dictionary.contains(candidateWord)){
//                System.out.println(candidateWord);
                list.add(i);
                backTracking(answer, string, dictionary, i, list, size);
                list.remove(list.size() - 1);
            }
        }

    }

}
