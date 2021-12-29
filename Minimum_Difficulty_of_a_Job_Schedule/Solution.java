package com.company;

import java.util.*;

/**
 You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).

 You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.

 Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].

 Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.



 Example 1:


 Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 Output: 7
 Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 Second day you can finish the last job, total difficulty = 1.
 The difficulty of the schedule = 6 + 1 = 7
 Example 2:

 Input: jobDifficulty = [9,9,9], d = 4
 Output: -1
 Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 Example 3:

 Input: jobDifficulty = [1,1,1], d = 3
 Output: 3
 Explanation: The schedule is one job per day. total difficulty will be 3.
 Example 4:

 Input: jobDifficulty = [7,1,7,1,7,1], d = 3
 Output: 15
 Example 5:

 Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 Output: 843
 */
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        if (length < d) {
            return -1;
        }

        int[][] table = new int[length][d + 1];

        // initialize the table
        for(int i = 0; i < length; i++) {
            Arrays.fill(table[i], -1);
        }

        int minDifficulty = Integer.MAX_VALUE;

        return findMinDifficulty(jobDifficulty, 0, d, table);
    }

    public int findMinDifficulty(int[] jobDifficulty, int start, int d, int[][]table) {
        int length = jobDifficulty.length;
        int minDifficulty = Integer.MAX_VALUE;
        if (length - start + 1 < d) {
            // not a valid case
            return Integer.MAX_VALUE;
        }
        int curMax = Integer.MIN_VALUE;
        for(int j = start; j < length; j++ ) {
            curMax = Math.max(curMax, jobDifficulty[j]);
            if (d == 1) {
                minDifficulty = curMax;
            } else {
                if(table[j][d] == -1) {
                    int tmp = findMinDifficulty(jobDifficulty, j + 1, d - 1, table);
                    table[j][d] = tmp;
                }
                if (table[j][d] != Integer.MAX_VALUE) {
                    minDifficulty = Math.min(minDifficulty, table[j][d] + curMax);
                }
            }
        }
        return minDifficulty;
    }
}