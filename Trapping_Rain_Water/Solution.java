/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. */

public class Solution {
    public int trap(int[] A) {
        int len = A.length; 
        if(len <=2) {
            return 0; 
        }
        int result = 0; 
        int[] lMax = new int[len]; 
        lMax[0] = A[0];
        int leftMax = A[0]; 
        for(int i = 1; i < len; i++) {
            lMax[i] = leftMax; 
            if(A[i] > leftMax) {
                leftMax = A[i]; 
            }
        }
        int rightMax = A[len - 1]; 
        for(int j = len -2; j > 0; j--) {
            int minBar = lMax[j] < rightMax ? lMax[j] : rightMax; 
            if(minBar > A[j]) {
                result += minBar - A[j]; 
            }
            if(A[j] > rightMax) {
                rightMax = A[j]; 
            }
        }
        return result;
    }
}