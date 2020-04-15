package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for(int i = 0; i<stones.length; i++)
            queue.add(stones[i]);
        while(queue.size() > 1) {
            Integer val1 = queue.poll();
            Integer val2 = queue.poll();
            queue.add(val1-val2);
        }
        Assert.check(queue.poll().equals(1));
    }
}
