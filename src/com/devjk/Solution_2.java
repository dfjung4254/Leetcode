package com.devjk;

/*

    LeetCode Problem Solving
    2. Add Two Numbers
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 */
public class Solution_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ptr = ans;
        int carry = 0;
        int value = 0;

        while(true){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            value = sum % 10;
            ptr.val = value;

            l1 = l1.next;
            l2 = l2.next;
            if(l1 == null && l2 == null){
                break;
            }
            if(l1 == null) l1 = new ListNode(0);
            if(l2 == null) l2 = new ListNode(0);
            ptr.next = new ListNode(0);
            ptr = ptr.next;
        }

        if(carry != 0){
            ptr.next = new ListNode(carry);
        }

        return ans;
    }
}

/*
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}