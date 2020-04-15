package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

public class UnsortedSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        int n = nums.length;
        int beg = -1;
        int end= -2;
        int min = nums[n-1];
        int max = nums[0];
        for(int i = 1; i<n; i++) {
            min = Math.min(min, nums[n-1-i]);
            max = Math.max(max, nums[i]);
            if(nums[i] < max) end = i;
            if(nums[n-1-i] > min) beg = n-i-1;
        }


        Assert.check(end-beg+1 == 5);
    }

    private void old () {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        int r = nums.length-2;
        int l = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(l <= nums.length-1 && r >= 0) {
            if(nums[l] < nums[l-1]) {
                min = Math.min(nums[l], min);
            }
            if(nums[r] > nums[r+1]) {
                max = Math.max(nums[r], max);
            }
            l++;
            r--;
        }
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }


        Assert.check((r-l < 0 ? 0 : r-l+1) == 4);
    }
}
