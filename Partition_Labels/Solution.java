package com.company;

/*
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so
that each letter appears in at most one part, and return a list of integers representing the size of these parts.



Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] charIndex = new int[26];
        // iterate each character and record the first and last index
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            charIndex[c - 'a'] = i;
        }

        // now let's iterate again to split the string
        int partStart = 0;
        int partEnd = 0;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int index = charIndex[c - 'a'];
            if (i > partEnd) {
                result.add(partEnd - partStart + 1);
                partStart = i;
            }
            if (index > partEnd) {
                partEnd = index;
            }
        }
        result.add(partEnd - partStart + 1);
        return  result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result);
    }
}