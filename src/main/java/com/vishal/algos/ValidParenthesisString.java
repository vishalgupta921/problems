package com.vishal.algos;

import com.sun.tools.javac.util.Assert;

import java.util.Stack;

/**
 *
 * Valid Parenthesis String
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *  Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 *  Any right parenthesis ')' must have a corresponding left parenthesis '('.
 *  Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 *  '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 *  An empty string is also valid.
 *
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        Assert.check(checkValidString("(((******))"));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> startparanthesis = new Stack<>();
        Stack<Integer> asterix = new Stack<>();
        int x = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                startparanthesis.push(i);
            } else if(c == '*')
                asterix.push(i);
            else {
                if(!startparanthesis.isEmpty())
                    startparanthesis.pop();
                else if(!asterix.isEmpty())
                    asterix.pop();
                else
                    return false;
            }

        }
        while(!startparanthesis.isEmpty() && !asterix.isEmpty()) {
            if(asterix.pop() < startparanthesis.pop())
                return false;
        }
        return  startparanthesis.isEmpty();
    }

    /*
        Without that much sapce
        int m = (s == null) ? 0 : s.length();

        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < m; ++i) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    ++minCount;
                    ++maxCount;
                    break;
                case ')':
                    --minCount;
                    --maxCount;
                    break;
                case '*':
                    ++maxCount;
                    --minCount;
                    break;
            }

            if (maxCount < 0) {
                return false;
            }

            minCount = Math.max(0, minCount);
        }

        return minCount == 0;

     */
}
