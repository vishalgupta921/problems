package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

public class MaximumSubarray {

    public static void main (String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Integer maxValue = nums[0];
        Integer maxInLoop = nums[0];
        for(int i=1; i<nums.length;i++) {
            maxInLoop = Math.max(maxInLoop + nums[i], nums[i]);
            maxValue = Math.max(maxValue, maxInLoop);
        }
        Assert.check(maxValue == 6);
    }

    private void maxSubArrayOld() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Integer total = Integer.MIN_VALUE;
        int length = nums.length;
        for(int i=0; i<length;i++) {
            int sum = nums[i];
            total = Math.max(total, sum);
            for(int j=i+1; j<length;j++) {
                sum += nums[j];
                total = Math.max(total, sum);
            }
        }
    }
}
