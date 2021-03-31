package com.company;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/


import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String str : strs) {
            char[] key = str.toCharArray();
            Arrays.sort(key);
            String keyStr = String.valueOf(key);
            List<String> list = groupMap.get(keyStr);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            groupMap.put(keyStr, list);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(groupMap.values());
        return result;
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(s.groupAnagrams(strs));
    }
}