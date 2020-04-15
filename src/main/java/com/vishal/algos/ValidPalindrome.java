package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

public class ValidPalindrome {

    public static void main(String[] args) {
        Assert.check(isPalindrome("0P"));
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        s = s.toLowerCase();
        boolean matched = true;
        while (i < j){
            int c1= s.charAt(i) - 'a';
            int c2= s.charAt(j) - 'a';
            if(c1 < 0 || c1 > 25) {
                i++;
                continue;
            }
            if(c2 < 0 || c2 > 25) {
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
