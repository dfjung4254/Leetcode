package com.devjk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    return searchTreeWithBfs(root);
  }

  private List<List<Integer>> searchTreeWithBfs(TreeNode root) {

    List<List<Integer>> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Queue<Node> queue = new LinkedList<>();
    List<Integer> first = new ArrayList<>();

    int prevLevel = 0;
    queue.offer(new Node(root, prevLevel));
    while(!queue.isEmpty()) {
      Node curNode = queue.poll();
      TreeNode curTreeNode = curNode.treeNode;
      int curLevel = curNode.level;
      if(curLevel > prevLevel) {
        list.add(first);
        first = new ArrayList<>();
      }
      first.add(curTreeNode.val);
      prevLevel = curLevel;
      // left
      if(curTreeNode.left != null) {
        queue.offer(new Node(curTreeNode.left, curLevel + 1));
      }
      if(curTreeNode.right != null) {
        queue.offer(new Node(curTreeNode.right, curLevel + 1));
      }
    }
    list.add(first);
    return list;
  }

  private class Node {
    TreeNode treeNode;
    int level;
    Node (TreeNode treeNode, int level) {
      this.treeNode = treeNode;
      this.level = level;
    }
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
