package com.vishal.algos;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        rotate(arr, 3, 0);
        System.out.println(Arrays.toString(arr));
    }

    //for left rotate
    // 1234567 3 == 5671234
    public static void rotate(int[] array, int n, int i) {
        int source = i + n;
        if(source >= array.length)
            source = source % array.length;

        int temp = array[i];
        if(i < array.length - 1)
            rotate(array, n, i+1);

        array[source] = temp;
    }

    //for left rotate
    // 1234567 3 == 5671234
    public static void rotate_old_left(int[] array, int n) {
        int length = array.length;
        n = n%length;
        if(n==0)
            return;
        int gcd = gcd(n, length);
        for(int i=gcd; i<length;i++) {
            int temp = array[i];
            int j=i;
            while(true) {
                int k = j+n;
                if(k >= length)
                    k = k - length;
                if(k == i)
                    break;
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
    }

    //for right rotate
    // 1234567 3 == 4567123
    public static void rotate_old_right(int[] array, int n) {
        int length = array.length;
        n = n%length;
        if(n==0)
            return;
        int gcd = gcd(n, length);
        for(int i=0; i<gcd;i++) {
            int temp = array[i];
            int j=i;
            while(true) {
                int k = j+n;
                if(k >= length)
                    k = k - length;
                if(k == i)
                    break;
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
    }

    private static Integer gcd(int i, int j){
        if(j == 0)
            return i;
        return gcd(j, i%j);
    }
}
