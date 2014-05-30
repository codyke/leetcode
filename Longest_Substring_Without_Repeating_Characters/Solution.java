/*Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256]; 
        int i = 0; 
        int start; 
        int end;
        int k = 0; 
        int length = 0;
        int maxLen = 0; 
        start = 0; 
        end = start; 
        for(i = 0; i < 256; i++){
            hash[i] = -1;
        }
        while(end < s.length()){
            k = hash[s.charAt(end)]; 
            if(k != -1 && k >= start && k <= end) {
                hash[s.charAt(end)] = end; 
                start = k + 1; 
                length = end - start + 1; 
            } else {
                hash[s.charAt(end)] = end; 
                length++;
                if(maxLen < length) {
                    maxLen = length;
                }
            }
            end++; 
        }
        return maxLen; 
    }
}