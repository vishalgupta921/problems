package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

/**
 *
 * The Great XOR
 *
 * Given a long integer , count the number of values of  satisfying the following conditions:
 * * a^x > x
 * * 0<a<x
 * where  and  are long integers and  is the bitwise XOR operator.
 *
 */
public class TheGreatXOR {

    /**
     *
     * To solve this we just need to find the max value we can get by xor
     * like in case of 5(101) by xor we can get max 7(111) as maxset bit digits are
     * three only so our answer is 7-5 = 2
     * @param args
     */
    public static void main(String[] args) {
        int val = 5;
        int maxVal = 1;
        while(maxVal <= val)
            maxVal *= 2;

        int resp = maxVal-1-val;
        Assert.check(resp==2);
    }
}
