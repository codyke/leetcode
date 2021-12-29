package com.company;

import java.util.*;

/**
 Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note that the same word in the dictionary may be reused multiple times in the segmentation.



 Example 1:

 Input: s = "leetcode", wordDict = ["leet","code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple","pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 Output: false
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        Set<Integer> wordLengthSet = new HashSet<>();
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, true);

        for(String str : wordDict) {
            wordSet.add(str);
            wordLengthSet.add(str.length());
        }

        int[] wordLengthArray = new int[wordLengthSet.size()];
        int index = 0;
        for(Integer i : wordLengthSet) {
            wordLengthArray[index++] = i;
        }
        return wordBreakHelper(s, 0, wordLengthArray, wordSet, dp);
    }

    private boolean wordBreakHelper(String s, int start, int[] wordLengthArray,
                                    Set<String> wordSet, boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        if(!dp[start]) {
            return false;
        }
        for(int i = 0; i < wordLengthArray.length; i++) {
            if (start + wordLengthArray[i] > s.length()) {
                return false;
            }
            if (wordSet.contains(s.substring(start, start + wordLengthArray[i]))) {
                if (wordBreakHelper(s, start + wordLengthArray[i] , wordLengthArray, wordSet, dp)) {
                    return true;
                }
            }
        }
        dp[start] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(s.wordBreak(str, wordDict));
    }
}