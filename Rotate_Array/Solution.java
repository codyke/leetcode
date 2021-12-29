package com.company;

import java.util.*;

/**
 Given an array, rotate the array to the right by k steps, where k is non-negative.



 Example 1:

 Input: nums = [1,2,3,4,5,6,7], k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: nums = [-1,-100,3,99], k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 */


class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int length = nums.length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int length = nums.length;
        int[] firstPart = Arrays.copyOfRange(nums,0, length - k);
        int[] secondPart = Arrays.copyOfRange(nums, length - k, length);
        for(int i = 0; i < secondPart.length; i++) {
            nums[i] = secondPart[i];
        }

        for(int i = 0; i < firstPart.length; i++) {
            nums[i + secondPart.length] = firstPart[i];
        }
    }

}