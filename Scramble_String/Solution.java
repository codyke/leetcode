/* Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t

We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a

We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. */

public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        
        if(len1 != len2) {
            return false; 
        }
        
        if(len1 == 1) {
            return s1.equals(s2);
        }
        
        char[] ss1 = s1.toCharArray(); 
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1); 
        Arrays.sort(ss2); 
        if(Arrays.equals(ss1, ss2) == false) {
            return false; 
        }
        
        for(int i = 0; i < len2 - 1; i++) {
            String sub11 = s1.substring(0, i + 1); 
            String sub21 = s2.substring(0, i + 1); 
            String sub12 = s1.substring(i + 1); 
            String sub22 = s2.substring(i + 1);
            String rev1 = s2.substring(len2 - 1 - i); 
            String rev2 = s2.substring(0, len2 - 1 - i); 
            if(isScramble(sub11, sub21)  && isScramble(sub12, sub22)) {
                return true; 
            } else if(isScramble(sub11, rev1) && isScramble(sub12, rev2)) {
                return true; 
            }
        }
        
        return false; 
    }
}