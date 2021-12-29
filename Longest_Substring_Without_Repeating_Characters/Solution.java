package com.company;

import java.util.*;

/**
 Given a string s, find the length of the longest substring without repeating characters.



 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 Example 4:

 Input: s = ""
 Output: 0
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);

        int firstIdx = 0;
        int secondIdx = 0;
        while (secondIdx < s.length()) {
            char c = s.charAt(secondIdx);
            int idx = map[c];
            if (idx != -1 && idx >= firstIdx && idx <= secondIdx) {
                firstIdx = idx + 1;
            }
            map[c] = secondIdx;
            maxLength = Math.max(maxLength, secondIdx - firstIdx + 1);
            secondIdx++;
        }
        return maxLength;
    }
}