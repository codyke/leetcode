package com.company;

import java.util.*;

/**
 A peak element is an element that is strictly greater than its neighbors.

 Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

 You may imagine that nums[-1] = nums[n] = -∞.



 Example 1:

 Input: nums = [1,2,3,1]
 Output: 2
 Explanation: 3 is a peak element and your function should return the index number 2.
 Example 2:

 Input: nums = [1,2,1,3,5,6,4]
 Output: 5
 Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

 */
class Solution {
    public int findPeakElement(int[] nums) {
        int peakIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i - 1] >= nums[i]) {
                continue;
            }
            if(i + 1 < nums.length && nums[i + 1] >= nums[i]) {
                continue;
            }
            peakIndex = i;
            break;
        }
        return peakIndex;
    }

    public int findPeakElementByBinarySearch(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}