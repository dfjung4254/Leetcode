package com.devjk;

/*

    208. Implement Trie (Prefix Tree)
    Implement a trie with insert, search, and startsWith methods.
    Example:
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true

    Note:
        You may assume that all inputs are consist of lowercase letters a-z.
        All inputs are guaranteed to be non-empty strings.

 */

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Solution_208 {

    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }

    private static class Trie {
        /**
         * Initialize your data structure here.
         */

        private Map<Character, Node> node;

        public Trie() {
            this.node = new HashMap<>();
        }

        private class Node{
            public boolean isEnd;
            public Map<Character, Node> child;
            public Node(){
                this.isEnd = false;
                this.child = new HashMap<>();
            }
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node pointer = new Node();
            Map<Character, Node> cur_node = node;
            for(char ch : word.toCharArray()){
                if(!cur_node.containsKey(ch)){
                    Node val = new Node();
                    cur_node.put(ch, val);
                }
                pointer = cur_node.get(ch);
                cur_node = pointer.child;
            }
            pointer.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node pointer = new Node();
            Map<Character, Node> cur_node = node;
            for(char ch : word.toCharArray()){
                if(!cur_node.containsKey(ch)){
                    return false;
                }
                pointer = cur_node.get(ch);
                cur_node = pointer.child;
            }
            return pointer.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node pointer = new Node();
            Map<Character, Node> cur_node = node;
            for(char ch : prefix.toCharArray()){
                if(!cur_node.containsKey(ch)){
                    return false;
                }
                pointer = cur_node.get(ch);
                cur_node = pointer.child;
            }
            return true;
        }
    }

}
