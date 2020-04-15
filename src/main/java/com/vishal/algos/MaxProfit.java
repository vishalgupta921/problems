package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i] < prices[i+1])
                max += prices[i+1]-prices[i];
        }
        Assert.check(max == 7);
    }

    private void old() {
        int[] prices = new int[]{7,1,5,3,6,4};
        int max = 0;
        int buy = Integer.MAX_VALUE;
        for(int i=0;i<prices.length-1;i++){
            if(buy > prices[i])
                buy = prices[i];
            else if(prices[i] > prices[i+1]) {
                max += prices[i]-buy;
                buy = Integer.MAX_VALUE;
            }
        }
        max += buy != Integer.MAX_VALUE ? prices[prices.length-1]-buy : 0;
    }
}
