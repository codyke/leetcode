package com.company;

/*
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.



Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
*/


import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int mid = (left + right) >> 1;

        while(left < right) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                count += binarySearchCount(matrix[i], mid);
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
            mid = (left + right) >> 1;

        }

        return left;

    }

    private int binarySearchCount(int[] row, int target) {
        int n = row.length;
        if (row[0] > target) {
            return 0;
        } else if (row[n - 1] <= target) {
            return n;
        } else {
            int left = 0;
            int right = n - 1;
            int mid = (left + right) >> 1;
            while(left < right) {
                if(row[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
                mid = (left + right) >> 1;
            }
            return left;
        }
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        int[][] maxtrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        System.out.println(s.kthSmallest(maxtrix, 8));
    }
}