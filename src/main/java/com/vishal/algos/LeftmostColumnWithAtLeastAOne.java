package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 *
 */
public class LeftmostColumnWithAtLeastAOne {

    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrixImpl();
        int resp = leftMostColumnWithOne(binaryMatrix);
        int opt = leftMostColumnWithOne_optimise(binaryMatrix);
        Assert.check(resp == 0);
        Assert.check(opt == 0);
    }

    /**
     *
     * find the left most occurrence of 1 row wise
     *
     * @param binaryMatrix
     * @return
     */
    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int x = dimensions.get(0);
        int y = dimensions.get(1);
        int val = Integer.MAX_VALUE;
        for(int i = 0; i < x; i++) {
            int resp = findLowestOne(binaryMatrix, i, 0, y-1);
            val = Math.min(resp, val);
        }
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    private static int findLowestOne(BinaryMatrix binaryMatrix, int x, int i, int j) {
        int resp = Integer.MAX_VALUE;
        while(i <= j) {
            int mid = (i+j)/2;
            int val = binaryMatrix.get(x, mid);
            if(val == 1) {
                j = mid-1;
                resp = mid;
            }else
                i = mid+1;
        }
        return resp;
    }

    /**
     * Copied and optimise idea
     *
     * start from top right if 0 then mode down otherwise move left
     *
     * @param binaryMatrix
     * @return
     */
    public static int leftMostColumnWithOne_optimise(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int x = dimensions.get(0), y = dimensions.get(1);
        int i = 0, j = y-1;
        int resp = -1;
        while (i < x && j >= 0){
            if(binaryMatrix.get(i, j) == 0) {
                i++;
            }else
                resp = j--;
        }
        return resp;
    }

    interface BinaryMatrix {
     public int get(int x, int y);
      public List<Integer> dimensions();
  };

    static class BinaryMatrixImpl implements BinaryMatrix {

        @Override
        public int get(int x, int y) {
            if(x == 0 && y == 0) {
                return 0;
            } else if(x == 0 && y == 1) {
                return 0;
            } else if(x == 1 && y == 0) {
                return 1;
            } else if(x == 1 && y == 1) {
                return 1;
            }
            return -1;
        }

        @Override
        public List<Integer> dimensions() {
            List<Integer> list = new ArrayList<>();
            list.add(2);
            list.add(2);
            return list;
        }
    }

}


