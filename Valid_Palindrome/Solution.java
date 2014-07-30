/* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. */

public class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length(); 
        if (len <= 1 ) {
            return true; 
        }
        
        int start = 0; 
        int end = len - 1; 
        while(start <= end) {
            char a = s.charAt(start);
            if(!Character.isLetter(a) && 
               !Character.isDigit(a)) {
                start++;
                continue;
            }
            
            char b = s.charAt(end); 
            if(!Character.isLetter(b) && 
               !Character.isDigit(b)) {
                end--;
                continue;
            }
            
            if(Character.isLetter(a) && Character.isLetter(b)) {
                if(Character.toUpperCase(a) != 
                    Character.toUpperCase(b)) {
                    return false; 
                }
            } else if(Character.isDigit(a) && Character.isDigit(b)) {
                if(a != b) {
                    return false; 
                }
            } else {
                return false; 
            }
            start++;
            end--;
        }
        
        return true;
    }
}