package com.company;

import java.util.*;

/**
 Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

 It is guaranteed that the answer will fit in a 32-bit integer.

 A subarray is a contiguous subsequence of the array.



 Example 1:

 Input: nums = [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:

 Input: nums = [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */


class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int curMax = nums[0];
        int curMin = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int cmin = curMin * nums[i];
            int cmax = curMax * nums[i];
            curMax = Math.max(nums[i], Math.max(cmin, cmax));
            curMin = Math.min(nums[i], Math.min(cmin, cmax));
            max = Math.max(curMax, max);
        }
        return max;
    }

    public int maxProduct1(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        boolean[] hasNegativeNum = new boolean[nums.length + 1];

        hasNegativeNum[nums.length] = false;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 0) {
                hasNegativeNum[i] = false;
            } else {
                hasNegativeNum[i] = nums[i] < 0 | hasNegativeNum[i + 1];
            }
        }

        int first = 0;
        int second = 0;
        int curProduct = 1;
        while(first < nums.length && second < nums.length) {
            curProduct *= nums[second];
            maxProduct = Math.max(maxProduct, curProduct);
            if (curProduct < 0) {
                if (hasNegativeNum[second + 1]) {
                    second++;
                } else {
                    while(curProduct < 0) {
                        curProduct /= nums[first++];
                    }
                    if(first < second) {
                        maxProduct = Math.max(maxProduct, curProduct);
                    }
                    second = second + 1;
                }
            } else if (curProduct == 0) {
                first = second + 1;
                second = second + 1;
                curProduct = 1;
            } else {
                second = second + 1;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,-5,-2,-4,3};
        System.out.println(s.maxProduct(nums));
    }
}