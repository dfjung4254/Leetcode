package com.devjk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_49 {

    private List<List<String>> ans;
    private Pair[] pairs;

    public List<List<String>> groupAnagrams(String[] strs) {

        ans = new ArrayList<>();
        pairs = new Pair[strs.length];

        setPairs(strs);

        Arrays.sort(pairs, (Pair p1, Pair p2) -> {
            return p2.changed.compareTo(p1.changed);
        });

        String before = "";
        boolean init = true;
        for(Pair pa : pairs){
            if(init || !before.equals(pa.changed)){
                /* new list */
                init = false;
                ans.add(new ArrayList<>());
                before = pa.changed;
            }
            ans.get(ans.size() - 1).add(pa.origin);
        }

        return ans;
    }

    public void setPairs(String[] strs){
        for(int i = 0; i < strs.length; i++){
            sortEach(strs, i);
        }
    }

    public void sortEach(String[] strs, int idx){
        char[] charArray = strs[idx].toCharArray();
        Arrays.sort(charArray);
        pairs[idx] = new Pair(strs[idx], String.valueOf(charArray));
    }

    private static class Pair{
        String origin;
        String changed;
        Pair (String origin, String changed){
            this.origin = origin;
            this.changed = changed;
        }
    }

}
