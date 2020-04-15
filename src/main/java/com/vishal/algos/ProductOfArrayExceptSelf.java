package com.vishal.algos;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[nums.length-1] = 1;
        int val =1;
        for(int i =nums.length-2; i >= 0 ; i--){
            output[i] = output[i+1]*nums[i+1];
        }
        for(int i =0; i < nums.length ; i++){
            output[i] = val*output[i];
            val *= nums[i];
        }
        return output;
    }

    private static int[] productExceptSelf_old(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        int leftProd = 1, rightProd = 1;
        for(int i =1; i < nums.length; i++){
            leftProd *= nums[i-1];
            output[i] *= leftProd;
        }
        for(int i =nums.length-2; i >= 0 ; i--){
            rightProd *= nums[i+1];
            output[i] *= rightProd;
        }
        return output;
    }

    private static int[] productExceptSelf_with_divide(int[] nums) {
        int multiply = 1;
        int zeros = 0;
        for(int i = 0; i< nums.length; i++){
            zeros = nums[i] == 0 ? zeros+1 : zeros;
            if(zeros == 1 && nums[i] == 0)
                continue;
            multiply *= nums[i];
        }
        for(int i = 0; i< nums.length; i++){
            nums[i] = nums[i] == 0 ? multiply : zeros == 1 ? 0 : multiply/nums[i];
        }

        return nums;
    }
 }
