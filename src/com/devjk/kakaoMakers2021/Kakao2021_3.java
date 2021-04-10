package com.devjk.kakaoMakers2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kakao2021_3 {

  public int[] solution(int n, int[] passenger, int[][] train) {
    int[] answer = new int[2];

    int[] dist = new int[n + 1];
    List<Edge>[] graph = new ArrayList[n + 1];
    for (List<Edge> edge : graph) {
      edge = new ArrayList<Edge>();
    }
    for(int i = 0; i < train.length; i++) {
      graph[train[i][0]].add(new Edge(train[i][1], passenger[train[i][1] - 1]));
      graph[train[i][1]].add(new Edge(train[i][0], passenger[train[i][0] - 1]));
    }

    dist[1] = passenger[0];
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
      @Override
      public int compare(Edge o1, Edge o2) {
        if(o1.weight < o2.weight) return 1;
        else if(o1.weight == o2.weight) return 0;
        else return -1;
      }
    });
    pq.offer(new Edge(1, 0));
    while(!pq.isEmpty()) {
      Edge edge = pq.poll();
      for (int i = 0; i < graph[edge.vertex].size(); i++) {
        Edge tmp = graph[edge.vertex].get(i);
        if(dist[tmp.vertex] < edge.vertex + tmp.weight) {
          dist[tmp.vertex] = edge.vertex + tmp.weight;
          pq.add(new Edge(tmp.vertex, dist[tmp.vertex]));
        }
      }
    }

    int max = 0;
    for(int i = 1; i < dist.length; i++) {
      if(max < dist[i]) {
        max = dist[i];
        answer[0] = i;
        answer[1] = max;
      }
    }

    return answer;
  }

  class Edge{
    int vertex;
    int weight;
    public Edge(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }

}
