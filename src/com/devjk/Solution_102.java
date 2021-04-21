package com.devjk;

import java.util.List;

public class Solution_102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    return searchTree(root);
  }

  private List<List<Integer>> searchTree(TreeNode root) {


    System.out.println(root.val);
    searchTree(root.left);
    searchTree(root.right);

    return null;
  }

  private class TreeNode {
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
