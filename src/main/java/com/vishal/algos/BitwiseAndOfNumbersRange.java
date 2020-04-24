package com.vishal.algos;

import java.util.Date;

/**
 *
 * Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 */
public class BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    /**
     * In this we will to right shift till we got the same value/ bit
     * set for both numbers and then left shift the result number
     * we get the response
     *
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd1(int m, int n) {
        int shift = 0;
        while(n != m) {
            n >>= 1;
            m >>= 1;
            shift++;
        }

        return m << shift;
    }

    /**
     *
     * In this we set the rightmost bit of n so that we get the smallest value
     * of n, after & with m we can get the response
     *
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n) {
        while(n > m) {
            n &= n-1;
        }

        return m&n;
    }
}
