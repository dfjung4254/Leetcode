package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            answer += bfs(i, n, visited, computers);
            System.out.println("answer : " + answer);
        }

        return answer;
    }

    private int bfs(int idx, int n, boolean[] visited, int[][] computers){

        Queue<Integer> q = new LinkedList<>();

        if(!visited[idx]){
            q.offer(idx);
            visited[idx] = true;
            while(!q.isEmpty()){
                int curIdx = q.poll();
                for(int i = 0; i < n; i++){
                    if(!visited[i] && computers[curIdx][i] == 1){
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
            return 1;
        }

        return 0;
    }

}
