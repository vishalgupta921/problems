package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 * Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        Integer response = Arrays.stream(nums).reduce(0, (x,y) -> x ^ y);
        Assert.check(response.equals(4));
    }

    private static int singleNumber(int[] nums) {
        Integer response = 0;
        for(int i=0;i<nums.length;i++)
            response = response^nums[i];
        return response;
    }
}
