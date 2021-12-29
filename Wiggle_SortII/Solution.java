package com.company;

import java.util.*;

/**
 Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 You may assume the input array always has a valid answer.



 Example 1:

 Input: nums = [1,5,1,1,6,4]
 Output: [1,6,1,5,1,4]
 Explanation: [1,4,1,5,1,6] is also accepted.
 Example 2:

 Input: nums = [1,3,2,2,3,1]
 Output: [2,3,1,3,1,2]
 */

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = Arrays.copyOf(nums, nums.length);
        int leftStart = (nums.length - 1) / 2;
        int rightStart = nums.length - 1;
        int i = 0;
        while(i < nums.length) {
            nums[i++] = tmp[leftStart--];
            if (i >= nums.length) {
                break;
            }
            nums[i++] = tmp[rightStart--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,4,3,4,1,2,1,3,1,3,2,3,3};
        //int[] nums = {1, 5, 1, 1, 6 ,4};
        s.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}