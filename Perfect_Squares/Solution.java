package com.company;

import java.util.*;

/**
 Given an integer n, return the least number of perfect square numbers that sum to n.

 A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.



 Example 1:

 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.
 Example 2:

 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.
 */
class Solution {
    Map<Integer, Integer> result = new HashMap<>();
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j * j <= i; j++) {
                int num = dp[i - j * j] + 1;
                if (num < dp[i]) {
                    dp[i] = num;
                }
            }
        }
        return dp[n];
    }

    private int recursiveFindNumSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        if (result.containsKey(n)) {
            return result.get(n);
        }
        int curMin = Integer.MAX_VALUE;
        int i = 1;
        int square = i * i;
        while(square <= n) {
            int num = 0;
            if(result.containsKey(n - square)) {
                num = result.get(n - square) + 1;
            } else {
                num = recursiveFindNumSquares(n - square) + 1;
            }
            if (num < curMin) {
                result.put(n, num);
                curMin = num;
            }
            i++;
            square = i * i;
        }

        return curMin;
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        System.out.println(s.numSquares(16));
    }
}