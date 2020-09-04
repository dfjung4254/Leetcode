package com.devjk;

import java.util.HashMap;

public class Solution_138 {

    public Node copyRandomList(Node head) {

        /* As-IsHash -> To-beObj */
        HashMap<Integer, Node> hashMap = new HashMap<>();

        Node pNode = head;
        Node sNode = null;
        boolean isFirst = true;
        while(pNode != null){
            /* logic */
            /* make new to-be obj */
            Node node = new Node(pNode.val);
            node.next = pNode.next;
            node.random = pNode.random;

            if(isFirst){
                isFirst = false;
                sNode = node;
            }

            hashMap.put(pNode.hashCode(), node);

            pNode = pNode.next;
        }
        
        while(sNode != null){

            sNode.next = hashMap.get(sNode.next.hashCode());
            sNode.random = hashMap.get(sNode.random.hashCode());

            sNode = sNode.next;
        }

        return hashMap.get(head.hashCode());
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
