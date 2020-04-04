package com.devjk;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_101 sol = new Solution_101();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        sol.isSymmetric(tree);

    }

}
