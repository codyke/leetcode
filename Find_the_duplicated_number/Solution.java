package com.company;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
*/


import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        int fastIndex = nums[0];
        int slowIndex = nums[0];
        do {
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];
            fastIndex = nums[fastIndex];
        } while(fastIndex != slowIndex);

        slowIndex = nums[0];
        while(fastIndex != slowIndex) {
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];
        }

        return slowIndex;
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        int[] nums = {3,1,3,4,2};
        System.out.println(s.findDuplicate(nums));
    }
}