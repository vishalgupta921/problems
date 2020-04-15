package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.*;

public class CountingElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
        }

        Integer resp = 0;
        for(Integer key : map.keySet()) {
            if(map.get(key+1) != null)
                resp += map.get(key);
        }

        Assert.check(resp == 2);
    }


    private void old() {
        int[] arr = new int[]{1, 2, 3};
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : arr) {
            Integer val = map.get(i);
            val = val == null ? 1 : val+1;
            map.put(i, val);
        }

        Integer resp = 0;
        Integer lastKey = -2;
        Integer lastValue = -2;
        Integer n  = 0;
        Set<Integer> keys = map.keySet();
        for(Integer key : keys) {
            if(n == 0) {
                lastKey = key;
                lastValue = map.get(key);
                n++;
                continue;
            }
            Integer val = map.get(key);
            if(key == lastKey+1){
                resp += lastValue;
            }
            lastValue = val;
            lastKey = key;
        }
    }
}
