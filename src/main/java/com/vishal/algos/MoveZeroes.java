package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        int nonZeroIndices=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0)
                nums[nonZeroIndices++] = nums[i];
        }
        Arrays.fill(nums, nonZeroIndices, nums.length, 0);
        Assert.check(Arrays.toString(nums).equals("[1, 3, 12, 0, 0]"));
    }

    private void oldResp() {
        int[] nums = new int[]{0,1,0,3,12};
        int nonZeroIndices=-1;
        int zeroIndices=-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0 && zeroIndices == -1)
                zeroIndices = i;
            else if(nums[i] != 0 )
                nonZeroIndices = i;

            if(nonZeroIndices > zeroIndices && zeroIndices > -1) {
                int val = nums[nonZeroIndices];
                nums[nonZeroIndices] = nums[zeroIndices];
                nums[zeroIndices] = val;
                nonZeroIndices = zeroIndices;
                zeroIndices = nonZeroIndices+1;
            }
        }
    }

}
