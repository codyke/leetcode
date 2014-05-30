/*Write a function to find the longest common prefix string amongst an array of strings. */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int strNum = strs.length;
        String result = ""; 
        char c; 
        int i;
        int index = 0;
        while(strNum > 0){
            if (index >= strs[0].length()) {
                break; 
            } else {
                c = strs[0].charAt(index); 
            }
            for(i = 1; i < strNum; i++) {
                if(index >= strs[i].length() 
                    || strs[i].charAt(index) != c) {
                    index = strs[0].length(); 
                    break; 
                }
            }
            if (i == strNum) {
                result += c; 
            }
            index++;
        }
        return result; 
    }
}