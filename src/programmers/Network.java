package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public int solution(int n, int[][] computers){
        int answer = 0;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                answer++;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int k = 0; k < n; k++){
                        if(!visited[k] && computers[cur][k] == 1){
                            visited[k] = true;
                            q.add(k);
                        }
                    }
                }
            }
        }

        return answer;
    }

}
