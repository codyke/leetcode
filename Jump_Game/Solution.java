package com.company;

import java.util.*;

/**
 Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.



 Example 1:

 Input: nums = [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: nums = [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */


class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i = 0; i < nums.length; i++) {
            if(maxJump < i) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= nums.length -1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJumpDP(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i] |= dp[i + j];
                if(dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}