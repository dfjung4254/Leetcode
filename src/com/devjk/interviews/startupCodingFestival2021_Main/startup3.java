package com.devjk.interviews.startupCodingFestival2021_Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class startup3 {

  public static void main(String[] args) throws Exception {

    // input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] nq = input.split(" ");
    int size = Integer.parseInt(nq[0]);
    int qSize = Integer.parseInt(nq[1]);
    Set<Integer>[] childSet = new HashSet[size + 1];
    int[] parentMap = new int[size + 1];
    for(int i = 1; i <= size; i++) {
      childSet[i] = new HashSet<>();
    }
    for(int i = 1; i < size; i++) {
      input = br.readLine();
      nq = input.split(" ");
      int parent = Integer.parseInt(nq[0]);
      int child = Integer.parseInt(nq[1]);
      childSet[parent].add(child);
      parentMap[child] = parent;
    }
    int[][] queries = new int[qSize][2];
    for(int i = 0; i < qSize; i++) {
      input = br.readLine();
      nq = input.split(" ");
      queries[i][0] = Integer.parseInt(nq[0]);
      queries[i][1] = Integer.parseInt(nq[1]);
    }
    int rootIndex = 0;
    for(int i = 1; i <= size; i++) {
      if(parentMap[i] == 0) {
        rootIndex = i;
        break;
      }
    }

    // solve - tree dp + dfs?
    childSet[rootIndex].addAll(dfs(childSet, rootIndex));

    // query
    for(int[] query : queries) {
      int src = query[0];
      int dest = query[1];
      if(childSet[src].contains(dest)) {
        System.out.println("yes");
      }else{
        System.out.println("no");
      }
    }
  }

  static Set<Integer> dfs(Set<Integer>[] childSet, int currentIndex) {

    if(childSet[currentIndex].isEmpty()) {
      return childSet[currentIndex];
    }

    Set<Integer> plusSet = new HashSet<>();
    for(Integer childIndex : childSet[currentIndex]) {
      plusSet.addAll(dfs(childSet, childIndex));
    }
    childSet[currentIndex].addAll(plusSet);
    return childSet[currentIndex];
  }

}
