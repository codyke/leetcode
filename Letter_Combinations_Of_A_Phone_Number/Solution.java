package com.company;

import java.util.*;

/**
 Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

 We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.



 Example 1:

 Input: nums = [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Example 2:

 Input: nums = [2,0,1]
 Output: [0,1,2]
 Example 3:

 Input: nums = [0]
 Output: [0]
 Example 4:

 Input: nums = [1]
 Output: [1]
 */
class Solution {
    private char[][] key = {{'a','b','c'}, {'d','e','f'},
            {'g','h','i'}, {'j','k','l'},
            {'m','n','o'}, {'p','q','r','s'},
            {'t','u','v'}, {'w','x','y','z'}};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        backtracking(digits, 0, new StringBuilder());
        return result;
    }

    private void backtracking(String digits, int cur, StringBuilder sb) {
        if (cur == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int idx = digits.charAt(cur) - '2';

        for(int i = 0; i < key[idx].length; i++) {
            sb.append(key[idx][i]);
            backtracking(digits, cur + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinationsNonRecursive(String digits) {
        List<String> result = new ArrayList<>();
        if(!digits.isEmpty()) {
            result.add("");
        }
        for(int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int idx = c - '2';
            char[] chars = key[idx];
            List<String> tmp = new ArrayList<>();
            for(String s : result) {
                for(int j = 0; j < chars.length; j++) {
                    String str = s + chars[j];
                    tmp.add(str);
                }
            }
            result.clear();
            result.addAll(tmp);
        }

        return result;
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        System.out.println(String.join(",", s.letterCombinations("23")));
    }
}