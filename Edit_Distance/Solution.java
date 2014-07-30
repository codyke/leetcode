/* Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character*/

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(); 
        int len2 = word2.length(); 
        
        if(len1 == 0) {
            return len2;
        } else if (len2 == 0) {
            return len1; 
        }
        
        int[][] distance = new int[len1 + 1][len2 + 1]; 
        for(int i = 0; i < len1 + 1; i++) {
            distance[i][0] = i;
        }
        
        for(int j = 0; j < len2 + 1; j++) {
            distance[0][j] = j; 
        }
        
        for(int i = 1; i < len1 + 1; i++) {
            for(int j = 1; j < len2 + 1; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1]; 
                } else {
                    distance[i][j] = minValue(distance[i - 1][j - 1], distance[i - 1][j], distance[i][j - 1]) + 1; 
                }
            }
        }
        return distance[len1][len2];
    }
    
    public int minValue(int x, int y, int z) {
        if(x > y) {
            return y < z ? y : z; 
        } else {
            return x < z ? x : z; 
        }
    }
}