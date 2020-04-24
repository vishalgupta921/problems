package com.vishal.algos;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 */
public class LRUCacheImpl {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
    }
}


class LRUCache {

    Map<Integer, Integer> values = null;
    int capacity = 0;
    public LRUCache(int capacity) {
        values = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!values.containsKey(key))
            return -1;
        int val = values.remove(key);
        values.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if(values.containsKey(key))
            values.remove(key);
        if(values.size() == capacity) {
            values.remove(values.keySet().iterator().next());
        }

        values.put(key, value);
    }
}