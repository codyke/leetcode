/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> intToRomanMap = new HashMap<Integer, String>();
        intToRomanMap.put(1, "I");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(900, "CM");
        
        int tmp; 
        String result = ""; 
        int i; 
        int tens = 1000;
        while(tens > 0) {
            tmp = num % (tens * 10) / tens * tens;
            if (intToRomanMap.get(tmp) != null) {
                result += intToRomanMap.get(tmp);
            } else {
                if (tmp > 5 * tens) {
                    result += intToRomanMap.get(5 * tens);
                    tmp -= 5 * tens;
                }
                while(tmp > 0) {
                    result += intToRomanMap.get(tens);
                    tmp -= 1 * tens;
                }
            }
            tens /= 10;
        }
        //thousand
        /*tmp = num / 1000 * 1000; 
        while(tmp > 0){
            result += intToRomanMap.get(1000);
            tmp -= 1000;
        }
        
        //hundred 
        tmp = num % 1000 / 100 * 100;
        if (intToRomanMap.get(tmp) != null) {
            result += intToRomanMap.get(tmp);
        } else {
            if (tmp >= 500) {
                result += intToRomanMap.get(500);
                tmp -= 500;
            } 
            while(tmp > 0) {
                result += intToRomanMap.get(100);
                tmp -= 100;
            }
        }
        
        //ten 
        tmp = num % 100 / 10 * 10; 
        if (intToRomanMap.get(tmp) != null) {
            result += intToRomanMap.get(tmp);
        } else {
            if (tmp >= 50) {
                result += intToRomanMap.get(50);
                tmp -= 50;
            }
            while(tmp > 0) {
                result += intToRomanMap.get(10);
                tmp -= 10;
            }
        }
        
        tmp = num % 10;
        if (intToRomanMap.get(tmp) != null) {
            result += intToRomanMap.get(tmp);
        } else {
            if (tmp >= 5) {
                result += intToRomanMap.get(5);
                tmp -= 5;
            }
            while(tmp > 0){
                result += intToRomanMap.get(1);
                tmp -= 1;
            }
        }*/
        
        return result;
    }
}