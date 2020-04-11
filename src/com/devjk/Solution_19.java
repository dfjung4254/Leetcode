package com.devjk;

import java.util.ArrayList;
import java.util.List;

public class Solution_19 {

    private List<ListNode> list;

    public ListNode removeNthFromEnd(ListNode head, int n) {

        list = new ArrayList<>();
        ListNode nList = new ListNode(0);
        nList.next = head;
        list.add(nList);
        ListNode pNode = head;
        int size = 1;
        while (pNode != null) {
            list.add(pNode);
            pNode = pNode.next;
            size++;
        }
        int target = size - n - 1;
        for (int i = 0; i < size; i++) {
            if (i == target && i + 2 < size) {
                list.get(i).next = list.get(i + 2);
            } else if (i == target && i + 2 >= size) {
                list.get(i).next = null;
            }
        }

        return list.get(0).next;
    }

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */