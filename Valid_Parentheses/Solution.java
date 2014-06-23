/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

public class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<Character>();  
        int len = s.length(); 
        if(len == 0) {
            return true; 
        }
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i); 
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c); 
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char cc = stack.get(stack.size() - 1); 
                if((c == ')' && cc != '(') || 
                    (c == '}' && cc != '{') || 
                    (c == ']' && cc != '[')) {
                        return false; 
                } else {
                    stack.remove(stack.size() - 1); 
                }
            }
        }
        if(stack.isEmpty()) {
            return true; 
        } else {
            return false;
        }
    }
}