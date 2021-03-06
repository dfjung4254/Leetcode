package com.devjk;

/*

    222. Count Complete Tree Nodes
    Given a complete binary tree, count the number of nodes.
    Note:
        Definition of a complete binary tree from Wikipedia:
        In a complete binary tree every level, except possibly the last, is completely filled,
        and all nodes in the last level are as far left as possible.
        It can have between 1 and 2h nodes inclusive at the last level h.

 */
public class Solution_222 {

    private int ans = 0;

    public int countNodes(TreeNode root) {

        /* solve 1. recursive */
        doRecursiveSolve(root);

        return ans;
    }

    public void doRecursiveSolve(TreeNode curTree){

        if(curTree == null){
            return;
        }

        doRecursiveSolve(curTree.left);
        doRecursiveSolve(curTree.right);
        ans++;

    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
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
