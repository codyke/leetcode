package com.company;

import java.util.*;

/**
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 If target is not found in the array, return [-1, -1].

 Follow up: Could you write an algorithm with O(log n) runtime complexity?



 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 Example 3:

 Input: nums = [], target = 0
 Output: [-1,-1]
 */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        if (nums.length == 0) {
            return result;
        }
        int smaller = target - 1;

        int smallerIndex = findFisrtLargerThanTarget(nums, smaller);
        if (smallerIndex >= nums.length || nums[smallerIndex] != target) {
            return result;
        }
        int largerIndex = smallerIndex == - 1 ? -1 : findFisrtLargerThanTarget(nums, target);

        result[0] = smallerIndex;
        result[1] = largerIndex - 1;
        return result;
    }

    public int findFisrtLargerThanTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= left) {
            int middle = (left + right) / 2;
            int mid = nums[middle];
            if (mid > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,1,2,2,3,5,5,6,6,6,6,7,7,7,7,8,8,9,9};//{5,7,7,8,8,10};
        int[] result = s.searchRange(nums, 5);
        System.out.println(result[0] + " " + result[1]);
    }
}