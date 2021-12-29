package com.company;

import java.util.*;

/**
 The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

 countAndSay(1) = "1"
 countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 Example 1:

 Input: n = 1
 Output: "1"
 Explanation: This is the base case.
 Example 2:

 Input: n = 4
 Output: "1211"
 Explanation:
 countAndSay(1) = "1"
 countAndSay(2) = say "1" = one 1 = "11"
 countAndSay(3) = say "11" = two 1's = "21"
 countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = "1";
        for(int i = 1; i < n; i++) {
            s = helper(s);
        }
        return s;
    }

    public String helper(String s) {
        StringBuilder pre = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != c) {
                pre.append(count).append(c);
                count = 1;
                c = s.charAt(i);
            } else {
                count++;
            }
        }
        pre.append(count).append(c);
        return pre.toString();
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(5));
    }
}