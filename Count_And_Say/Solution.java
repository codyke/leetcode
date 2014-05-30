/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. */

import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        String result = ""; 
        String start = "1"; 
        result = start; 
        while(--n > 0) {
            int strLen = start.length(); 
            int index = 0; 
            int repeat = 0; 
            int curNum = 0;
            result = "";
            for(index = 0; index < strLen; index++) {
                if (repeat == 0) {
                    curNum = Character.getNumericValue(start.charAt(index)); 
                    repeat++; 
                } else if(curNum != 
                            Character.getNumericValue(start.charAt(index))){
                    // hit a new number
                    // flash out
                    result += Integer.toString(repeat) + Integer.toString(curNum); 
                    repeat = 1; 
                    curNum = Character.getNumericValue(start.charAt(index)); 
                } else {
                    repeat++;
                }
            }
            // flash out
            result += Integer.toString(repeat) + Integer.toString(curNum); 
            start = result; 
        }
        return result; 
    }
}