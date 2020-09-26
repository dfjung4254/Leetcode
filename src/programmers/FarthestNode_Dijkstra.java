package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FarthestNode_Dijkstra {

    private final int INF = 987654321;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        Node[] nodes = new Node[n + 1];
        for(int i = 1; i <= n; i++){
            nodes[i] = new Node(i, INF);
        }

        for(int[] ce : edge){
            nodes[ce[0]].next.add(new int[]{ce[1], 1});
            nodes[ce[1]].next.add(new int[]{ce[0], 1});
        }

        /* dijkstra + heap */
        nodes[1].dist = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(nodes[1]);
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            for(int[] next : curNode.next){
                Node nextNode = nodes[next[0]];
                int distFromCurrentNode = next[1];
                if(nextNode.dist > curNode.dist + distFromCurrentNode){
                    nextNode.dist = curNode.dist + distFromCurrentNode;
                    pq.offer(nextNode);
                }
            }
        }

        int curMax = -1;
        for(int i = 1; i <= n; i++){
            if(curMax < nodes[i].dist){
                curMax = nodes[i].dist;
                answer = 1;
            }else if(curMax == nodes[i].dist){
                answer++;
            }
        }

        return answer;
    }

    private class Node implements Comparable<Node> {
        int index;
        int dist;
        List<int[]> next;
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
            this.next = new ArrayList<>();
        }
        @Override
        public int compareTo(Node o){
            if(this.dist > o.dist){
                return 1;
            }
            return -1;
        }
    }

}
