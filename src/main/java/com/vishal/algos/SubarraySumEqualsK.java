package com.vishal.algos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Subarray Sum Equals K
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Input:nums = [0,0,0,0,0,0,0,0,0,0], k =0
 * Output: 55
 *
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {

    }

    /**
     *
     * In this we are finding the subarray by removing that we can find the corresponding sum
     * in [1, 1, 1], k =2
     * map -> {(1, 1), (2,1)}
     * in first condition we get one count when sum ==k
     * and in second when we find (3-2) = 1 found in the k that means
     * by removing that index we can get the sum = 2 that means
     * count = 1+map.get(1) = 2 which is the result
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length;i++) {
            sum = sum+nums[i];
            if(sum == k)
                count++;

            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    /**
     *
     * O(n^2) approach
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length;i++) {
            Integer sum = 0;
            for(int j=i; j<nums.length;j++) {
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}
