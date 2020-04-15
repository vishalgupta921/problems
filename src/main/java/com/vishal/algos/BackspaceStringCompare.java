package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        String S = "a##c";
        String T = "#a#c";

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i = 0; i< S.length(); i++) {
            char c = S.charAt(i);
            if(c == '#') {
                if(s1.size() > 0) s1.pop();
            }else
                s1.push(c);
        }
        for(int i = 0; i< T.length(); i++) {
            char c = T.charAt(i);
            if(c == '#') {
                if(s2.size() > 0) s2.pop();
            }else
                s2.push(c);
        }
        Assert.check(s1.equals(s2));
    }
}
