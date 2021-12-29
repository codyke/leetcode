package com.company;

import java.util.*;

/**
 There is an integer array nums sorted in ascending order (with distinct values).

 Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

 Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.



 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 Example 3:

 Input: nums = [1], target = 0
 Output: -1
 */


class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(end >= start) {
            int middle = (start + end) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if (nums[middle] >= nums[start]) {
                if (nums[middle] > target ) {
                    if (target >= nums[start]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                } else {
                    start = middle + 1;
                }
            } else {
                if (nums[middle] > target) {
                    end = middle - 1;
                } else {
                    if (target >= nums[start]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                }
            }
        }
        return  -1;
    }

    private int divideAndSearch(int[] nums, int start, int end, int target) {
        if (end < start) {
            return -1;
        }
        int found = -1;
        if (nums[end] > nums[start]) {
            found = binarySearch(nums, start, end, target);
        } else {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                found = middle;
            } else {
                found = divideAndSearch(nums, start, middle - 1, target);
                if (found == -1) {
                    found = divideAndSearch(nums, middle + 1, end, target);
                }
            }
        }
        return found;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int found = -1;

        if (target < nums[start] || target > nums[end]) {
            return found;
        }

        while(start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                found = middle;
                break;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return found;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5, 1, 3};//{4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(s.search(nums, target));
    }
}
