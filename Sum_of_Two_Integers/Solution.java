package com.company;

/**
 Given two integers a and b, return the sum of the two integers without using the operators + and -.



 Example 1:

 Input: a = 1, b = 2
 Output: 3
 Example 2:

 Input: a = 2, b = 3
 Output: 5
 */
class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int and = a & b;

        while (and != 0) {
            and = and << 1;
            int tmp = xor;
            xor = and ^ xor;
            and = and & tmp;
        }

        return xor;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getSum(1, 1));
        System.out.println(s.getSum(1, 2));
        System.out.println(s.getSum(2, 3));
        System.out.println(s.getSum(7, 1));
    }
}