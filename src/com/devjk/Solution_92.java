package com.devjk;

public class Solution_92 {

  public ListNode92 reverseBetween(ListNode92 head, int left, int right) {

    ListNode92 before = null;
    ListNode92 pointer = head;
    ListNode92 after = head.next;




    return head;
  }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode92 {
  int val;
  ListNode92 next;
  ListNode92() {}
  ListNode92(int val) {
    this.val = val;
  }
  ListNode92(int val, ListNode92 next) {
    this.val = val;
    this.next = next;
  }
}