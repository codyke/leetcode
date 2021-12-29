package com.company;

import java.util.*;

/**
 You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

 There are two types of logs:

 Letter-logs: All words (except the identifier) consist of lowercase English letters.
 Digit-logs: All words (except the identifier) consist of digits.
 Reorder these logs so that:

 The letter-logs come before all digit-logs.
 The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
 The digit-logs maintain their relative ordering.
 Return the final order of the logs.



 Example 1:

 Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 Explanation:
 The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 Example 2:

 Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

 */
class Solution {
    int minLength = Integer.MAX_VALUE;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>();
        for(String s : words) {
            wordSet.add(s);
            minLength = Math.min(minLength, s.length());
        }
        wordSet.addAll(Arrays.asList(words));

        List<String> result = new ArrayList<>();
        for(String s : words) {
            if (isConcatenatedWords(s, 0, 0, wordSet)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean isConcatenatedWords(String word, int start, int count, Set<String> wordSet) {
        if(start == word.length() && count > 1) {
            return count > 1 ? true : false;
        }
        StringBuilder sb = new StringBuilder();
        boolean result;
        for(int i = start; i < word.length(); i++) {
            sb.append(word.charAt(i));
            if(i >= start + minLength - 1 && wordSet.contains(sb.toString())) {
                result = isConcatenatedWords(word, i + 1, count + 1, wordSet);
                if(result) {
                    return true;
                }
            }
        }
        return false;
    }
}