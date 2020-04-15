package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,0,0,0,1,1};
        int[] arr = new int[nums.length*2+1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int max = 0;
        int sum = nums.length;
        for(int i=0; i<nums.length; i++){
            sum +=  nums[i]*2 -1;
            // to check with same sum comes again that means in between sum is 0
            if(arr[sum] != -2) {
                max = Math.max(max, i-arr[sum]);
            }else
                arr[sum] = i;
        }
        Assert.check(max == 6);
    }

    private void old() {
        int[] nums = new int[]{0,0,1,0,0,0,1,1};
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int max = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i] == 0 ? -1 : 1;
            // to check with same sum comes again that means in between sum is 0
            if(sumMap.containsKey(sum)) {
                max = Math.max(max, i-sumMap.get(sum));
            }else
                sumMap.put(sum, i);
        }
    }
}
