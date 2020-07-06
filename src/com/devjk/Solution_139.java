package com.devjk;

import java.util.*;

public class Solution_139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean ans = false;
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        int size = s.length();
        boolean[] visited = new boolean[size];
        q.add(0);
        while(!q.isEmpty()){
            int start = q.poll();
            if(!visited[start]) {
                for (int end = start + 1; end <= size; end++) {
                    if (wordSet.contains(s.substring(start, end))) {
                        if (end == size) {
                            ans = true;
                            break;
                        }
                        q.add(end);
                    }
                }
                visited[start] = true;
            }
        }

        return ans;
    }

}
