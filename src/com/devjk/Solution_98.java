package com.devjk;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution_98 {

  public boolean isValidBST(TreeNode98 root) {
    return searchBST(root, null, null);
  }

  private boolean searchBST(TreeNode98 node, Integer min, Integer max) {

    // check validate value
    if(min != null && min >= node.val) {
      return false;
    }

    if(max != null && node.val >= max){
      return false;
    }

    // check next child value
    if(node.left == null && node.right == null) {
      return true;
    }

    boolean ret = false;
    if(node.left != null && node.right == null) {
      // go left
      ret = searchBST(node.left, min, node.val);
    }else if(node.left == null && node.right != null) {
      // go right
      ret = searchBST(node.right, node.val, max);
    }else if(node.left != null && node.right != null) {
      // go left, go right
      ret = searchBST(node.left, min, node.val) && searchBST(node.right, node.val, max);
    }

    return ret;
  }

}

class TreeNode98 {
  int val;
  TreeNode98 left;
  TreeNode98 right;
  TreeNode98() {}
  TreeNode98(int val) { this.val = val; }
  TreeNode98(int val, TreeNode98 left, TreeNode98 right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}