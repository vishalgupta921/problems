package com.vishal.algos;

/**
 *
 * Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<=j) {
            if(nums[i] == target)
                return i;
            if(nums[j] == target)
                return j;
            i++;
            j--;
        }
        return -1;
    }

    public int search_using_BS(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            } else  {
                if(target > nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

}
