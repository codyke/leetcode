package com.company;

import java.util.*;

/**
 You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

 Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 You may assume that you have an infinite number of each kind of coin.



 Example 1:

 Input: coins = [1,2,5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Example 3:

 Input: coins = [1], amount = 0
 Output: 0
 Example 4:

 Input: coins = [1], amount = 1
 Output: 1
 Example 5:

 Input: coins = [1], amount = 2
 Output: 2
 */


class Solution {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        if(coins[0] > amount) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            if (i < coins[0]) {
                continue;
            }
            for(int coin : coins) {
                if(i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                } else {
                    break;
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] coins = {186,419,83,408}; 6249
        int[] coins = {474,83,404,3};
        s.coinChange(coins, 264);
    }
}