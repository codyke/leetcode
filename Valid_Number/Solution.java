/*Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. */

public class Solution {
    public boolean isNumber(String s) {
        int length = s.length(); 
        int i = 0; 
        boolean numberBegin = false; 
        boolean result = true; 
        boolean dot = false;
        boolean e = false; 
        boolean space = false;
        boolean hasNumEnd = false; 
        char c =' '; 
        for(i = 0; i < length; i++) {
            // space 
            if (numberBegin == false) {
                if(s.charAt(i) == ' ') {
                    continue;
                } 
                if(s.charAt(i) == '+' || s.charAt(i) =='-'){
                    numberBegin = true; 
                    c = s.charAt(i); 
                    continue; 
                }
                if(s.charAt(i) == '.') {
                    dot = true;
                    numberBegin = true; 
                    c = s.charAt(i); 
                    continue; 
                }
                if(s.charAt(i) == 'e') {
                    return false; 
                }
            }

            if(Character.isDigit(s.charAt(i)) && space == false){
                c = s.charAt(i); 
                numberBegin = true;
                hasNumEnd = true; 
            } else if(s.charAt(i) == '.' && dot == false && e == false && (c == '+' || c == '-' || Character.isDigit(c))){
                // . can comes after '+', '-' and digit
                // . can not in the part of e
                c = s.charAt(i); 
                dot = true; 
            } else if(s.charAt(i) == 'e' && e == false && ((c == '.' && hasNumEnd) || Character.isDigit(c))) {
                // e can comes after '.'(with valid number before) and digit
                c = s.charAt(i);
                e = true; 
                hasNumEnd = false;
            } else if(s.charAt(i) == ' ' && (c == ' ' || c == '.' || Character.isDigit(c))){
                // space should only come after ' ', '.' and digit
                c = s.charAt(i); 
                space = true; 
                continue;
            } else if((s.charAt(i) == '+' || s.charAt(i) == '-') && c == 'e'){
                // +/- can comes after e
                continue; 
            } else{
                return false; 
            }
        }
       if (numberBegin == true && hasNumEnd == true) {
           return true;
       } else {
           return false;
       }
    }
}