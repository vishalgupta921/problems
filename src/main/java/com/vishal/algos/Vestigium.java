package com.vishal.algos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int test = 1;
        while(testCases-- > 0) {
            int edges = sc.nextInt();
            int[][] sq = new int[edges][edges];
            for(int i = 0; i < edges; i++)
                for(int j = 0; j < edges; j++)
                    sq[i][j] = sc.nextInt();
            int sum =  0;
            int rowCount = 0;
            int colCount = 0;
            for(int i = 0; i < edges; i++) {
                boolean hasDuplicateInRow = false;
                boolean hasDuplicateInColumn = false;
                Set<Integer> elementsInRow = new HashSet<>();
                Set<Integer> elementsInCol = new HashSet<>();
                for(int j = 0; j < edges; j++) {
                    if(i == j)
                        sum += sq[i][j];
                    if(!elementsInRow.add(sq[i][j]))
                        hasDuplicateInRow = true;
                    if(!elementsInCol.add(sq[j][i]))
                        hasDuplicateInColumn = true;
                }
                if(hasDuplicateInRow)
                    rowCount++;
                if(hasDuplicateInColumn)
                    colCount++;
            }
            System.out.println("Case #"+
                    test++ +": "+sum+" "+
                    rowCount+" "+colCount);
        }
    }
}
