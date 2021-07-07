package com.devjk;

public class Solution_61 {

  public ListNode rotateRight(ListNode head, int k) {

    int nodeSize = getSize(head);

    if(nodeSize == 0 || nodeSize == 1) {
      return head;
    }

    k %= nodeSize;

    while (k-- > 0) {
      head = rotate(head);
    }

    return head;
  }

  private int getSize(ListNode head) {

    int size = 0;

    ListNode cur = head;
    while (cur != null) {
      size++;
      cur = cur.next;
    }

    return size;
  }

  private ListNode rotate(ListNode head) {

    // in memory first node
    ListNode first = head;
    ListNode lastPrev = getLastPrevNode(head);
    ListNode last = lastPrev.next;

    last.next = first;
    lastPrev.next = null;

    return last;
  }

  private ListNode getLastPrevNode(ListNode head) {

    ListNode before = null;
    ListNode cur = head;
    while(cur != null) {
      if(cur.next == null) {
        return before;
      }
      before = cur;
      cur = cur.next;
    }

    return null;
  }

  private class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
