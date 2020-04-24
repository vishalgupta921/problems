package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

/**
 *
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '1', '1', '0'};
        grid[1] = new char[]{'1', '1', '0', '1', '0'};
        grid[2] = new char[]{'1', '1', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '0', '0'};
        int count = 0;
        rows = grid.length;
        columns = grid[0].length;
        for(int i= 0; i< rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == '1'){
                    numIslandsHandler(grid, i, j);
                    count++;
                }
            }
        }
        Assert.check(count == 1);
    }

    static int rows = 0;
    static int columns = 0;
    public static void numIslandsHandler(char[][] grid, int i, int j) {
        if(i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        numIslandsHandler(grid, i-1, j);
        numIslandsHandler(grid, i+1, j);
        numIslandsHandler(grid, i, j-1);
        numIslandsHandler(grid, i, j+1);
    }
}
