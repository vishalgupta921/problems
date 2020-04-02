package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        Assert.check(isHappy(19));
    }

    private static boolean isHappy(int n) {
        Set<Integer> values = new HashSet<>();
        while(n != 1) {
            if(!values.add(n))
                return false;
            n = calculateDigitsSquareSum(n);
        }
        return true;
    }

    private static Integer calculateDigitsSquareSum(int n) {
        Integer resp = 0;
        while(n != 0) {
            int lastDigit = n%10;
            resp = resp+(lastDigit*lastDigit);
            n = n/10;
        }
        return resp;
    }

    private static boolean isHappyOldLogic(int n) {
        List<Integer> values = new ArrayList<>();
        values.add(n);
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        Integer digSqSum = calculateDigitsSquareSum(n);
        Integer checkSingleDigit = digSqSum%10;
        if(digSqSum == 1 || (checkSingleDigit == digSqSum && checkSingleDigit == 7))
            return true;
        if(values.contains(digSqSum) || checkSingleDigit == digSqSum)
            return false;
        values.add(digSqSum);

        return isHappy(digSqSum);
    }

}
