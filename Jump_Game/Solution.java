/* Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. */

public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length; 
        if(len <= 1) {
            return true; 
        }
        int next = 0; 
        int cur = 0; 
        while(cur < len) {
            next = cur; 
            int end = cur + A[cur]; 
            for(int i = cur; i <= end && i < len; i++) {
                if(A[i] + i > next) {
                    next = i + A[i]; 
                }
            }
            if(next >= len - 1) {
                return true; 
            }
            if(next == cur) {
                return false; 
            }
            cur = next;
        }
        
        return false; 
    }
    
}