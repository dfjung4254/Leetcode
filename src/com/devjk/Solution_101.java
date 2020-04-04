package com.devjk;

import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution_101 {

    private Queue<TreeNode> q;
    private List<TreeNode> list;

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null){
            if(left.val == right.val) return (isMirror(left.right, right.left) && isMirror(left.left, right.right));
        }
        return false;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}