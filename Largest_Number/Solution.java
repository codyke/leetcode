package com.company;

import java.util.*;

/**
 Given a list of non-negative integers nums, arrange them such that they form the largest number.

 Note: The result may be very large, so you need to return a string instead of an integer.



 Example 1:

 Input: nums = [10,2]
 Output: "210"
 Example 2:

 Input: nums = [3,30,34,5,9]
 Output: "9534330"
 Example 3:

 Input: nums = [1]
 Output: "1"
 Example 4:

 Input: nums = [10]
 Output: "10"
 */

class Solution {
    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numStr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                int r = o1o2.compareTo(o2o1);
                if (r > 0) {
                    return -1;
                } else if (r < 0) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });

        StringBuilder sb = new StringBuilder();
        boolean nonZero = false;
        for(String s : numStr) {
            if (!nonZero && s.equals("0")) {
                continue;
            }
            nonZero = true;
            sb.append(s);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 0};
        System.out.println(s.largestNumber(nums));
    }
}