package com.devjk;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_429 {

  public List<List<Integer>> levelOrder(Node root) {
    return searchNaryTreeWithBfs(root);
  }

  private List<List<Integer>> searchNaryTreeWithBfs(Node root) {

    List<List<Integer>> list = new LinkedList<>();
    if(root == null) {
      return list;
    }
    List<Integer> curList = new LinkedList<>();
    Queue<Pair> queue = new LinkedList<>();
    int prevLevel = 0;
    queue.offer(new Pair(root, prevLevel));
    while(!queue.isEmpty()) {
      Pair curPair = queue.poll();
      Node curNode = curPair.node;
      int curLevel = curPair.level;

      if(prevLevel < curLevel) {
        list.add(curList);
        curList = new LinkedList<>();
      }

      curList.add(curNode.val);
      curNode.children.forEach(childNode -> {
        queue.offer(new Pair(childNode, curLevel + 1));
      });
      prevLevel = curLevel;

    }
    list.add(curList);

    return list;
  }

  private class Pair {
    Node node;
    int level;
    public Pair(Node node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  private class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

}
