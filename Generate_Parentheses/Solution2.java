package com.company;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8

*/


import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] stack = new char[2*n];
        int leftParenthesis = n;
        int rightParenthesis = n;
        int idx = 0;
        Arrays.fill(stack, ' ');
        stack[idx] = '(';
        leftParenthesis--;
        idx++;
        while (idx >= 0) {
            char c = stack[idx];
            if (c == '(') {
                leftParenthesis++;
                if (leftParenthesis < rightParenthesis && rightParenthesis > 0) {
                    stack[idx] = ')';
                    rightParenthesis--;
                    idx++;
                } else {
                    stack[idx] = ' ';
                    idx--;
                }
            } else if (c == ')') {
                rightParenthesis++;
                stack[idx] = ' ';
                idx--;
            } else if (c == ' ') {
                if (leftParenthesis > 0) {
                    stack[idx] = '(';
                    leftParenthesis--;
                    idx++;
                } else if (rightParenthesis > 0) {
                    stack[idx] = ')';
                    rightParenthesis--;
                    idx++;
                } else {
                    idx--;
                }
            }
            if (idx == stack.length) {
                result.add(new String(stack));
                idx--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}