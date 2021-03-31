package com.company;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 */
class Solution2 {
    List<List<String>>[] dpTable;
    boolean[][] palindrome;
    public List<List<String>> partition(String s) {
        dpTable = new List[s.length() + 1];
        palindrome = new boolean[s.length()][s.length()];
        return partitionHelper(s, 0);
    }

    public List<List<String>> partitionHelper(String s, int startIdx) {
        List<List<String>> result = new ArrayList<>();
        if (startIdx >= s.length()) {
            result.add(new ArrayList<>());
        }
        for(int i = startIdx; i < s.length() ; i++) {
            if (!isPalindrome(s, startIdx, i)) {
                continue;
            }
            List<List<String>> tmpResult = dpTable[i + 1];
            if (tmpResult == null) {
                tmpResult = partitionHelper(s, i + 1);
            }
            String str = s.substring(startIdx, i + 1);
            for(List<String> tmp : tmpResult) {
                List<String> l = new ArrayList<>();
                l.add(str);
                l.addAll(tmp);
                result.add(l);
            }
        }
        dpTable[startIdx] = result;
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if ((s.charAt(start) == s.charAt(end)) && (end - start <= 2 || palindrome[start + 1][end - 1])) {
            palindrome[start][end] = true;
            return true;
        }
        return false;
//        int i = start;
//        int j = end;
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
    }

    public static void main(String[] arg) {
        Solution2 s = new Solution2();
        List<List<String>> result = s.partition("abbab");
        for(List<String> l : result) {
            System.out.println(l);
        }

    }
}