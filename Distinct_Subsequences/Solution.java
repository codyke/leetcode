/* Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3. */

public class Solution {
    public int numDistinct(String S, String T) {
        int lenS = S.length(); 
        int lenT = T.length(); 
        
        if(lenS < lenT) {
            return 0; 
        } else if (lenT == 0) {
            return lenS; 
        }
        
        int[][] count = new int[lenT + 1][lenS + 1]; 
        count[0][0] = 1; 
        for(int j = 0; j <= lenS; j++) {
            count[0][j] = 1; 
        }
        
        for(int i = 1; i <= lenT; i++) {
            for(int j = i; j <= lenS; j++) {
                if(S.charAt(j - 1) == T.charAt(i - 1)) {
                    count[i][j] = count[i - 1][j - 1] + count[i][j - 1]; 
                } else {
                    count[i][j] = count[i][j - 1]; 
                }
            }
        }
        
        return count[lenT][lenS]; 
    }
}