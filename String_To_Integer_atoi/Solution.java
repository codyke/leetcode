/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. */

import java.lang.Character;

public class Solution {
    public int atoi(String str) {
        int length = str.length(); 
        int i = 0; 
        int result = 0; 
        int sign = 1; 
        int Max = Integer.MAX_VALUE;
        int Min = Integer.MIN_VALUE;
        int tmp;
        boolean numberBegin = false; 
        for(i = 0; i < length; i++) {
            char c = str.charAt(i); 
            if (numberBegin == false) {
                // '+' '-' could only appear in first position 
                if (c == '-') {
                    sign *= -1; 
                    numberBegin = true;
                    continue; 
                } else if (c == '+') {
                    sign *= 1; 
                    numberBegin = true;
                    continue; 
                }
                
            }
            if (Character.isDigit(c)) {
                tmp = Character.getNumericValue(c); 
                if (sign > 0) {
                    if (Max / 10 < result 
                        || Max - result * 10 < tmp) {
                        result = Max; 
                        break;
                    }
                }
               
                if (sign < 0) {
                    if (Min / 10 > result 
                        || Min - result * 10 > tmp * sign){
                        result = Min;
                        break;
                    }
                }
 
                result = result * 10 + sign * tmp; 
                numberBegin = true; 
            } else if (c == ' ' && numberBegin == false) {
                continue; 
            } else {
                break; 
            }
        }
        return result;
    }
}