/* Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack. */

public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return null; 
        }
        
        int haystackLen = haystack.length(); 
        int needleLen = needle.length(); 
        
        if(needleLen == 0) {
            return haystack;
        }
        if (haystackLen == 0 || needleLen > haystackLen) {
            return null; 
        } 
        
        int i = 0; 
        int j = 0; 
        int k = 0; 
        for(i = 0; i <= haystackLen - needleLen; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                for(k = i + 1, j = 1; j < needleLen; k++, j++){
                    if(haystack.charAt(k) != needle.charAt(j)){
                        break;
                    }
                }
                if(j == needleLen) {
                    return haystack.substring(i); 
                }
            }
        }
        return null;
    }
}