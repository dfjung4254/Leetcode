package com.devjk;

/*

    146. LRU Cache
    Design and implement a data structure for Least Recently Used (LRU) cache.
    It should support the following operations: get and put.
    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present.
    When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.
    Follow up:
        Could you do both operations in O(1) time complexity?
    Example:
        LRUCache cache = new LRUCache( 2 // capacity  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Solution_146 {

    private class LRUCache {

        /* member variables */
        private int capacity;
        private LinkedHashMap<Integer, Integer> cache;

        public LRUCache(int capacity){
            this.capacity = capacity;
            this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public void put(int key, int value){
            this.cache.put(key, value);
        }

        public int get(int key){
            return this.cache.getOrDefault(key, -1);
        }

    }

}
