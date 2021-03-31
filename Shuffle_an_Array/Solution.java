package com.company;

/*
Given an integer array nums, design an algorithm to randomly shuffle the array.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.


Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    private int[] original;
    private int[] random;
    private Random rand;

    public Solution(int[] nums) {
        this.original = Arrays.copyOf(nums, nums.length);
        this.random = Arrays.copyOf(nums, nums.length);
        rand = new Random(nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < this.random.length; i++) {
            int newIdx = rand.nextInt(this.original.length);
            int tmp = random[i];
            random[i] = random[newIdx];
            random[newIdx] = tmp;
        }
        return this.random;
    }

    public
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */