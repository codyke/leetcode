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
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        for(String s : logs) {
            char c = s.charAt(s.indexOf(" ") + 1);
            if (Character.isAlphabetic(c)) {
                letterLogs.add(s);
            } else {
                digitLogs.add(s);
            }
        }
        Collections.sort(letterLogs, (a, b) -> {

            int indexA = a.indexOf(" ") + 1;
            int indexB = b.indexOf(" ") + 1;
            int result = a.substring(indexA).compareTo(b.substring(indexB));

            if (result != 0) {
                return result;
            } else {
                return a.substring(0, indexA).compareTo(b.substring(0, indexB));
            }

        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[logs.length]);
    }
}