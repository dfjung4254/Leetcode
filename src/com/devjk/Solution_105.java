package com.devjk;

import java.util.HashMap;
import java.util.Map;

public class Solution_105 {

  private int preorderIndex;
  private Map<Integer, Integer> inorderIndexMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    preorderIndex = 0;
    inorderIndexMap = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }

    return searchTree(preorder, 0, preorder.length - 1);
  }

  private TreeNode searchTree(int[] preorder, int left, int right) {

    if(left > right) {
      return null;
    }

    int rootValue = preorder[preorderIndex++];
    int nextRootIndex = inorderIndexMap.get(rootValue);

    TreeNode node = new TreeNode(rootValue);
    node.left = searchTree(preorder, left, nextRootIndex - 1);
    node.right = searchTree(preorder, nextRootIndex + 1, right);

    return node;
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
