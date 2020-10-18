package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery_dijkstra {

    private final int INF = 987654321;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        /* make linkedlist */
        Node[] nodes = new Node[N + 1];
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(i);
        }
        for(int[] currentRoad : road){
            int a = currentRoad[0];
            int b = currentRoad[1];
            int weight = currentRoad[2];
            nodes[a].next.add(new int[]{weight, b});
            nodes[b].next.add(new int[]{weight, a});
        }

        nodes[1].dist = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(nodes[1]);
        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            int currentDist = currentNode.dist;
            System.out.println("curNode : " + currentNode.index + " / " + currentDist);
            List<int[]> currentNext = currentNode.next;
            for(int[] nextEdge : currentNext){
                int nextWeight = nextEdge[0];
                int nextIndex = nextEdge[1];
                if(currentDist + nextWeight < nodes[nextIndex].dist){
                    nodes[nextIndex].dist = currentDist + nextWeight;
                    pq.offer(nodes[nextIndex]);
                }
            }
        }

        for(int i = 1; i < nodes.length; i++){
            if(nodes[i].dist <= K){
                answer++;
            }
        }

        return answer;
    }

    private class Node implements Comparable<Node>{
        int index;
        int dist;
        List<int[]> next;
        public Node(int index){
            this.index = index;
            this.next = new ArrayList<>();
            this.dist = INF;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dist > o.dist){
                return 1;
            }
            return -1;
        }
    }

}
