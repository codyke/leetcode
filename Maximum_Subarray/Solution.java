/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

public class Solution {
    /*public int maxSubArray(int[] A) {
        // scan from last item and only keep the max(A[i], maxSum + A[i])
        
        int len = A.length; 
        if(len == 0) {
            return 0;
        }
        int maxSum = A[len - 1];
        int result = maxSum; 
        for(int i = len - 2; i >=0; i--) {
            maxSum = maxSum + A[i] > A[i] ? maxSum + A[i] : A[i]; 
            if (maxSum > result) {
                result = maxSum;
            }
        }
        return result;
    }
    */
    public int maxSubArray(int[] A) {
        int len = A.length; 
        if(len == 0) {
            return 0;
        }
        
        return findMaxSubArray(A, 0, len - 1); 
    }
    
    public int findMaxSubArray(int[] A, int start, int end) {
        if(end < start) {
            return Integer.MIN_VALUE; 
        } 
        
        int mid = (start + end) / 2; 
        int maxLeft = findMaxSubArray(A, start, mid - 1); 
        int maxRight = findMaxSubArray(A, mid + 1, end); 
        
        int midLeft = 0; 
        int sum = 0;
        for(int i = mid - 1; i >= start; i--) {
            sum += A[i]; 
            if(sum > midLeft) {
                midLeft = sum; 
            }
        }
        int midRight = 0; 
        sum = 0; 
        for(int i = mid + 1; i <= end; i++) {
            sum += A[i]; 
            if(sum > midRight) {
                midRight = sum; 
            }
        }
        
        int maxMid = midLeft + midRight + A[mid]; 
        
        int result = maxLeft > maxRight ? maxLeft : maxRight; 
        result = result > maxMid ? result : maxMid; 
        return result; 
    }
}

