/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = new HashMap<Character, Integer>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
        
        int length = s.length();
        int result = 0; 
        int i = 0;
        int tmp = 0;
        for(i = length - 1; i >= 0; i--) {
            tmp = romanToIntMap.get(s.charAt(i));
            if (i + 1 >= length) {
                result += tmp;
            } else if (tmp >= romanToIntMap.get(s.charAt(i + 1))) {
                result += tmp;
            } else if (tmp < romanToIntMap.get(s.charAt(i + 1))) {
                result -= tmp;
            }
        }
        return result; 
    }
}