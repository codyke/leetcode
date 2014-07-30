/* Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. */

public class Solution {
    public int firstMissingPositive(int[] A) {
        int length = A.length; 
        if(length == 0) {
            return 1; 
        }
        
        int i = 0; 
        while(i < length) {
            if(A[i] <= 0) {
                i++; 
                continue; 
            }
            int index = A[i] - 1; 
            if(index < length && A[index] != A[i]) {
                //swap 
                int tmp = A[i];
                A[i] = A[index]; 
                A[index] = tmp; 
            } else {
                i++; 
            }
        }
        i = 0; 
        while(i < length) {
            if(A[i] != i + 1) {
                break; 
            }
            i++;
        }
        return i + 1;
    }
}