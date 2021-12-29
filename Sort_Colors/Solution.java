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
    public void sortColors(int[] nums) {
        int zeroIdx = 0;
        int oneIdx = 0;
        int twoIdx = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                swap(nums, zeroIdx, i);
                zeroIdx++;
            } else if (nums[i] == 1) {
                swap(nums, oneIdx, i);
                oneIdx++;
            } else {
                swap(nums, twoIdx, i);
                twoIdx++;
            }

            if (oneIdx < zeroIdx) {
                oneIdx = zeroIdx;
            }
            if (twoIdx < oneIdx) {
                twoIdx = oneIdx;
            }

            if (twoIdx > i) {
                i++;
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        int[] nums = new int[]{1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}