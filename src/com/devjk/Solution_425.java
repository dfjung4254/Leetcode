package com.devjk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_425 {

    public List<List<String>> wordSquares(String[] words) {

        List<List<String>> ans = new ArrayList<>();

        if(words.length != 0){
            solve_backtracking(ans, words, new HashSet<String>(), new ArrayList<String>(), 0, words[0].length());
        }

        return ans;
    }

    private void solve_backtracking(List<List<String>> ans, String[] words, HashSet<String> visited, List<String> list, int index, int size){

        if(index >= size){
            /* end */
            ans.add(new ArrayList<>(list));
            System.out.print("find Ans -> ");
            for(String debugWord : list){
                System.out.print(debugWord + " ");
            }
            System.out.println();
            return;
        }

        for(String word : words){
            if(isValid(word, index, list)){
                list.add(word);
                solve_backtracking(ans, words, visited, list, index + 1, size);
                list.remove(index);
            }
        }

    }

    private boolean isValid(String word, int index, List<String> list){

        boolean ret = true;

        System.out.println("isValid : " + word);
        for(String debugWord : list){
            System.out.print(debugWord + " ");
        }
        System.out.println();

        for(int i = 0; i < index; i++){
            if(word.charAt(i) != list.get(i).charAt(index)){
                ret = false;
                break;
            }
        }

        System.out.println("return : " + ret);

        return ret;
    }

}
