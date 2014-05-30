/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" */

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        int leftParenthese = n;
        int rightParenthese = n; 
        char[] stack = new char[2*n]; 
        int curPos = 0;
        int i;
        for(i = 0; i < 2 * n; i++){
            stack[i] = '0';
        }
        
        ArrayList<String> result = new ArrayList<String>();
        
        // beginning condition 
        stack[0] = '(';
        curPos++;
        leftParenthese--;
        while(curPos >= 0) {
            if(stack[curPos] == '0') {
                if (leftParenthese > 0) {
                    // we can insert left parenthese 
                    stack[curPos] = '(';
                    curPos++;
                    leftParenthese--;
                } else {
                    if (rightParenthese > leftParenthese) {
                        stack[curPos] = ')';
                        curPos++;
                        rightParenthese--;
                    }
                }
            } else if (stack[curPos] == '(') {
                // already try '(', now try ')'
                if (rightParenthese > 0 
                        && rightParenthese - 1 > leftParenthese) {
                            stack[curPos] = ')';
                            curPos++;
                            rightParenthese--;
                            leftParenthese++;
                        }
                 else {
                     // bail out
                     stack[curPos] = '0';
                     curPos--;
                     leftParenthese++;
                 }
            } else if (stack[curPos] == ')') {
                // bail out
                stack[curPos] = '0';
                curPos--;
                rightParenthese++;
            }
            
            if (rightParenthese == 0 && curPos > 2 * n - 1) {
                // A successful answer
                String answer = new String(stack); 
                result.add(answer);
                curPos = 2 * n - 1;
            }
        }
        
        return result;
        
    }
}