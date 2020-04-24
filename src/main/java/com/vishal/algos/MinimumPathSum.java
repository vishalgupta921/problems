package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

/**
 *
 * Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};
        rows = grid.length;
        columns = grid[0].length;
        minPathSumHelper_old(grid, 0, 0, 0);

        int[] dp = new int[columns+1];
        for(int j = 1; j<=columns; j++)
            dp[j] = dp[j-1] + grid[0][j-1];
        for(int i= 1; i < rows; i++) {
            for(int j = 1; j <= columns; j++) {
                dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j-1];
            }
        }
        Assert.check(dp[columns] == 7);
        Assert.check(minSum == 7);
    }

    private void minPathOld(int[][] grid) {
        /*
        for(int j = 1; j < columns; j++)
             grid[0][j] += grid[0][j-1];

        for(int i = 1; i < rows; i++)
            grid[i][0] += grid[i-1][0];
         */
        for(int i= 0; i<rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(i == 0 && j > 0) {
                    grid[i][j] += grid[i][j-1];
                } else if(j == 0 && i > 0) {
                    grid[i][j] += grid[i-1][j];
                } else if(j > 0 && i > 0) {
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        int val = grid[rows-1][columns-1];
       /*
       int[][] memo = new int[m][n];
        return helper(grid,m-1,n-1,memo);

        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0)
            return Integer.MAX_VALUE;
        if(memo[i][j]>0) return memo[i][j];

        memo[i][j] = grid[i][j] + Math.min(helper(grid,i-1,j,memo), helper(grid,i,j-1,memo));
        return memo[i][j];

        */
    }

    static int rows = 0;
    static int columns = 0;
    static int minSum = Integer.MAX_VALUE;
    private static void minPathSumHelper_old(int[][] grid, int i, int j, int sum) {
        if(i < 0 || i >= rows || j < 0 || j >= columns)
            return;
        if(i == rows-1 && j == columns-1) {
            minSum = Math.min(minSum, sum + grid[i][j]);
            return;
        }
        minPathSumHelper_old(grid, i+1, j, sum+grid[i][j]);
        minPathSumHelper_old(grid, i, j+1, sum+grid[i][j]);
    }

}
