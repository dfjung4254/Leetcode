package com.devjk.challenge.march2021;

public class Week3_ConstructBinaryTreeFromString {

  public TreeNode str2tree(String s) {

    TreeNode ans = new TreeNode();

    if(s.length() == 0) {
      return null;
    }

    int lastIndex = solve(ans, s, 0, s.length());

    return ans;
  }

  private int solve(TreeNode node, String s, int index, int size) {
    StringBuilder stringBuilder = new StringBuilder();
    while(index < size) {
      char currentCharacter = s.charAt(index);
      if(currentCharacter == '(') {
        setCurrentNodeValue(node,stringBuilder);
        index = processLeftCase(node, index, size, s);
      }else if(currentCharacter == ')') {
        setCurrentNodeValue(node,stringBuilder);
        System.out.println(index);
        return index;
      }else {
        stringBuilder.append(currentCharacter);
      }
      index++;
    }
    setCurrentNodeValue(node, stringBuilder);
    // no use
    return index;
  }

  private void setCurrentNodeValue(TreeNode node, StringBuilder sb) {
    if(sb.length() != 0) {
      node.val = Integer.parseInt(sb.toString());
    }
  }

  private int processLeftCase(TreeNode node, int index, int size, String s) {
    // go child
    int ret = 0;
    if(node.left == null) {
      // go left
      node.left = new TreeNode();
      ret = solve(node.left, s, index + 1, size);
    }else {
      // go right
      node.right = new TreeNode();
      ret = solve(node.right, s, index + 1, size);
    }
    return ret;
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
