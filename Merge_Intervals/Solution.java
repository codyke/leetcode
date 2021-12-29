package com.company;

import java.util.*;

/**
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



 Example 1:

 Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: intervals = [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.


 Constraints:

 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 */


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    if (o1[1] < o2[1]) {
                        return -1;
                    } else if(o1[1] > o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        List<int[]> intervalContainer = new ArrayList<>();
        int[] tmp = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > tmp[1]) {
                intervalContainer.add(tmp);
                tmp = intervals[i];
            } else {
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
        }
        intervalContainer.add(tmp);
        return intervalContainer.toArray(new int[intervalContainer.size()][2]);

    }

    private void sort(int[][] intervals, int start, int end) {
        if (start >= end) {
            return;
        }

        int l = start;
        int r = end + 1;
        int pivot = intervals[start][0];
        int[] temp;
        while (true) {
            while (intervals[++l][0] < pivot) {
                if (l == end) break;
            }

            while (intervals[--r][0] > pivot) {
                if (r == start) break;
            }

            if (l >= r) {
                break;
            }

            temp = intervals[l];
            intervals[l] = intervals[r];
            intervals[r] = temp;
        }

        temp = intervals[r];
        intervals[r] = intervals[start];
        intervals[start] = temp;

        sort(intervals, start, r - 1);
        sort(intervals, r + 1, end);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{5, 8}, {3, 6}, {1, 2}};
        System.out.println(s.merge(intervals));
    }
}