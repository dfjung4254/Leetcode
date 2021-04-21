package com.devjk;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {

    public static void main(String[] args) {

        Solution_102 sol = new Solution_102();
        Solution_102.TreeNode node = new Solution_102.TreeNode(3);
        node.left = new Solution_102.TreeNode(9);
        node.right = new Solution_102.TreeNode(20);
        node.right.left = new Solution_102.TreeNode(15);
        node.right.right = new Solution_102.TreeNode(7);
        System.out.println(sol.levelOrder(node).toString());

    }

}
