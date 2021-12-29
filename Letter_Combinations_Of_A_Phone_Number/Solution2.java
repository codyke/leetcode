/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/

import java.lang.Character; 

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        char[][] key = {{'a','b','c',' '}, {'d','e','f',' '},
                        {'g','h','i',' '}, {'j','k','l',' '},
                        {'m','n','o',' '}, {'p','q','r','s'},
                        {'t','u','v',' '}, {'w','x','y','z'}};
        ArrayList<String> result = new ArrayList<String>(); 
        ArrayList<String> tmp = new ArrayList<String>(); 
        if(digits.length() > 0) {
            int i = 0; 
            int num = Character.getNumericValue(digits.charAt(0)); 
            int iteration = (num != 9 && num != 7)?3:4; 
            if(digits.length()  == 1) {
                for(i = 0; i < iteration; i++){
                    String s = Character.toString(key[num - 2][i]); 
                    result.add(s); 
                }
            } else {
                tmp = letterCombinations(digits.substring(1)); 
                int size = tmp.size(); 
                int k = 0;
                for(k = 0; k < size; k++){
                    String s = tmp.get(k);
                    for(i = 0; i < iteration; i++) {
                        String ss = Character.toString(key[num - 2][i]); 
                        result.add(ss + s);
                    }
                }
            }
        } else {
            result.add("");
        }
        return result; 
    }
}