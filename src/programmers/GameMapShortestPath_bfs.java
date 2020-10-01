package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestPath_bfs {

    private final int[] DI = {0, 1, 0, -1};
    private final int[] DJ = {1, 0, -1, 0};
    private int n;
    private int m;

    public int solution(int[][] maps) {
        int answer = 0;

        this.n = maps.length;
        this.m = maps[0].length;
        int[][] visited = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            for(int d = 0; d < 4; d++){
                int ni = ci + DI[d];
                int nj = cj + DJ[d];
                if(isValid(ni, nj) && visited[ni][nj] == 0 && maps[ni][nj] == 1){
                    visited[ni][nj] = visited[ci][cj] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        if(visited[n - 1][m - 1] == 0){
            answer = -1;
        }else{
            answer = visited[n - 1][m - 1];
        }

        return answer;
    }

    private boolean isValid(int i, int j){
        return (i >= 0 && i < this.n && j >= 0 && j < this.m);
    }

}
