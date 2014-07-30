/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
    public int minCut(String s) {
        int len = s.length(); 
        if(len == 0) {
            return 0; 
        }
        int[] result = new int[len + 1]; 
        boolean[][] palidrome = new boolean[len][len]; 
        
        for(int i = 0; i < len + 1; i++) {
            result[i] = len - i; 
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(i == j) {
                    palidrome[i][j] = true; 
                } else {
                    palidrome[i][j] = false; 
                }
            }
        }
        
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if((j - i < 2 && s.charAt(i) == s.charAt(j)) || 
                    (s.charAt(i) == s.charAt(j) && palidrome[i + 1][j - 1] == true)) {
                        palidrome[i][j] = true; 
                        result[i] = minValue(result[i], result[j + 1] + 1); 
                    }
            }
        }
        
        return result[0] - 1; 
    }
    
    public int minValue(int v1, int v2) {
        if(v1 > v2) {
            return v2; 
        } else {
            return v1; 
        }
    }
    
    public boolean isPalidrome(String s) {
        int len = s.length(); 
        if(len <= 1) {
            return true; 
        }
        int start = 0; 
        int end = len - 1; 
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true; 
    }
}