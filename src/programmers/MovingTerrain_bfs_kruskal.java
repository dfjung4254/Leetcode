package programmers;

import java.util.*;

public class MovingTerrain_bfs_kruskal {

    private final int[] DI = {0, 1, 0, -1};
    private final int[] DJ = {1, 0, -1, 0};

    public int solution(int[][] land, int height) {
        int answer = 0;

        boolean[][] visited = new boolean[land.length][land.length];
        int[][] groupedLand = new int[land.length][land.length];
        int groupIdx = 0;
        /* bfs + kruskal + unionfind */
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land.length; j++){
                if(!visited[i][j]){
                    /* bfs - new group */
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        groupedLand[cur[0]][cur[1]] = groupIdx;
                        for(int d = 0; d < 4; d++){
                            int ni = cur[0] + DI[d];
                            int nj = cur[1] + DJ[d];
                            if(isValidPos(ni, nj, land.length) && !visited[ni][nj] && Math.abs(land[ni][nj] - land[cur[0]][cur[1]]) <= height){
                                visited[ni][nj] = true;
                                q.add(new int[]{ni, nj});
                            }
                        }
                    }
                    groupIdx++;
                }
            }
        }

        List<Vertex> vt = new ArrayList<>();
        int[] root = new int[groupIdx];
        for(int i = 0; i < root.length; i++){
            root[i] = i;
        }

        for(int i = 0; i < groupedLand.length; i++){
            for(int j = 0; j < groupedLand.length; j++){
                for(int d = 0; d < 2; d++){
                    int ni = i + DI[d];
                    int nj = j + DJ[d];
                    if(isValidPos(ni, nj, groupedLand.length) && groupedLand[ni][nj] != groupedLand[i][j]){
                        /* add vertex */
                        int weight = Math.abs(land[ni][nj] - land[i][j]);
                        vt.add(new Vertex(groupedLand[i][j], groupedLand[ni][nj], weight));
                    }
                }
            }
        }

        vt.sort(Comparator.comparingInt(o -> o.weight));

        int size = vt.size();
        /* kruskal + unionfind */
        for (Vertex cur : vt) {

            int ra = findRoot(cur.a, root);
            int rb = findRoot(cur.b, root);
            if(ra != rb){
                root[rb] = ra;
                answer += cur.weight;
            }

        }

        return answer;
    }

    private int findRoot(int a, int[] root){
        if(root[a] == a){
            return a;
        }else{
            return root[a] = findRoot(root[a], root);
        }
    }

    private class Vertex {
        int a;
        int b;
        int weight;
        public Vertex(int a, int b, int weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }

    private boolean isValidPos(int i, int j, int size){
        return (i >= 0 && i < size && j >= 0 && j < size);
    }

}
