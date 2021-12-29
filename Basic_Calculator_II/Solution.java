package com.company;

import java.util.*;

/**
 Given a string s which represents an expression, evaluate this expression and return its value.

 The integer division should truncate toward zero.



 Example 1:

 Input: s = "3+2*2"
 Output: 7
 Example 2:

 Input: s = " 3/2 "
 Output: 1
 Example 3:

 Input: s = " 3+5 / 2 "
 Output: 5
 */


class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int currentNum = 0;
        int lastNum = 0;
        int result = 0;
        char op = '+';
        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if(Character.isDigit(curChar)) {
                currentNum = currentNum * 10 + curChar - '0';
            }
            if(!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == s.length() - 1) {
                if(op == '+' || op == '-') {
                    result += lastNum;
                    lastNum = op == '+' ? currentNum :-currentNum;
                } else if (op == '*') {
                    lastNum *= currentNum;
                } else if (op == '/') {
                    lastNum /= currentNum;
                }
                op = curChar;
                currentNum = 0;
            }
        }
        return result + lastNum;
    }


    public static void main(String[] arg) {
        Solution s = new Solution();
        System.out.println(s.calculate("3+2+2*2"));
    }
}