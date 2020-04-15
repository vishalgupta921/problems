package com.vishal.algos;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    public static void main(String[] args) {
        Solution sol = new Solution(new int[]{1, 2, 3});
        sol.shuffle();
        sol.reset();
    }
}

class Solution {

    int[] arr;
    int[] original;
    public Solution(int[] nums) {
        arr = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arr = original;
        original = original.clone();
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < arr.length; i++){
            swap(i, new Random().nextInt(arr.length - i)+i);
        }
        return arr;
    }

    private void swap(int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

class SolutionOld {

    int[] arr;
    int[] original;
    int shuffle = 0;
    public SolutionOld(int[] nums) {
        arr = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        System.out.println(Arrays.toString(arr));
        reset_helper(arr, arr.length-1);
        shuffle = 0;
        return arr;
    }

    public void reset_helper(int[] nums, int i) {
        int source = i+shuffle;
        if(source >= nums.length) {
            source = source%nums.length;
        }
        int temp = nums[i];
        if(i > 0)
            shuffle_helper(nums, i-1);

        nums[source] = temp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        shuffle++;
        shuffle_helper(arr, 0);
        return arr;
    }

    public void shuffle_helper(int[] nums, int i) {
        int source = i+1;
        if(source >= nums.length) {
            source = source%nums.length;
        }
        int temp = nums[i];
        if(i < nums.length-1)
            shuffle_helper(nums, i+1);

        nums[source] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */