/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5. */

public class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        if (length == 0) {
            return 0; 
        }
        
        int i; 
        int result = 0;
        boolean wordBegin = false; 
        for(i = length - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if (wordBegin) {
                    break; 
                } else {
                    continue;
                }
            }
            result++;
            wordBegin = true;
        }
        
        return result;
    }
}