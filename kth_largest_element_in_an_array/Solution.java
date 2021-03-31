package com.company;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/


import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i++) {
            if(minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(s.findKthLargest(nums, 2));
    }
}