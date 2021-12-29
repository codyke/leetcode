package com.company;

import java.util.*;

/**
 Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.



 Example 1:

 Input: s = "aaabb", k = 3
 Output: 3
 Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input: s = "ababbc", k = 2
 Output: 5
 Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


 Constraints:

 1 <= s.length <= 104
 s consists of only lowercase English letters.
 1 <= k <= 105

 */
class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringHelper(s, 0, s.length(), k);
    }

    public int longestSubstringHelper(String s, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }
        int[] freqCount = new int[26];
        for(int idx = start; idx < end; idx++) {
            freqCount[s.charAt(idx) - 'a']++;
        }

        for(int mid = start; mid < end; mid++) {
            if (freqCount[s.charAt(mid) - 'a'] >= k) {
                continue;
            }
            int midNext = mid + 1;
            while(midNext < end) {
                if(freqCount[s.charAt(midNext) - 'a'] >= k) {
                    break;
                }
                midNext++;
            }

            return Math.max(longestSubstringHelper(s, start, mid, k), longestSubstringHelper(s, midNext, end, k));
        }
        return end - start;
    }

    public static void main(String[] arg) {
        Solution s = new Solution();
        System.out.println(s.longestSubstring("bbaaacbd", 3));
    }
}