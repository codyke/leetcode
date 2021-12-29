package com.company;

import java.util.*;

/**
 Given a string s, return the longest palindromic substring in s.



 Example 1:

 Input: s = "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: s = "cbbd"
 Output: "bb"
 Example 3:

 Input: s = "a"
 Output: "a"
 Example 4:

 Input: s = "ac"
 Output: "a"
 */

class Solution {
    public String longestPalindrome(String s) {
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int[] tmp = new int[2];
            tmp[0] = i;
            tmp[1] = i;
            stack.push(tmp);
        }
        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = i + 1;
                stack.push(tmp);
            }
        }
        int[] longestStringIndex = new int[2];
        int longestLength = 0;
        while (!stack.isEmpty()) {
            int[] tmp = stack.pop();
            if (tmp[1] - tmp[0] + 1 > longestLength) {
                longestStringIndex[0] = tmp[0];
                longestStringIndex[1] = tmp[1];
                longestLength = tmp[1] - tmp[0] + 1;
            }
            int leftIndex = tmp[0] - 1;
            int rightIndex = tmp[1] + 1;
            if (leftIndex < 0 || rightIndex > s.length() - 1 || s.charAt(leftIndex) != s.charAt(rightIndex)) {
                continue;
            } else {
                tmp = new int[2];
                tmp[0] = leftIndex;
                tmp[1] = rightIndex;
                stack.push(tmp);
            }
        }
        return s.substring(longestStringIndex[0], longestStringIndex[1] + 1);
    }

    public static  void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("aaaa"));
    }
}