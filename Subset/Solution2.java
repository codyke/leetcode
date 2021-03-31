package com.company;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /* add an empty set */
        List<Integer> emptySet = new ArrayList<>();

        generateSubset(result, emptySet,0, nums);
        return result;
    }

    private void generateSubset(List<List<Integer>> result, List<Integer> interSet, int startIdx, int[] nums) {
        result.add(interSet);
        for(int idx = startIdx; idx < nums.length; idx++) {
            List<Integer> tmpSet = new ArrayList<>(interSet);
            tmpSet.add(nums[idx]);
            generateSubset(result, tmpSet, idx + 1, nums);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        System.out.println(s.subsets(nums));
    }
}