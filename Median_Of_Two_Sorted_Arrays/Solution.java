/*There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).*/

import java.lang.*;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // find kth smallest element 
        int m = A.length;
        int n = B.length; 
        if ((m + n) % 2 == 1) {
            // odd: find (m+n)/2 + 1
            return findKthElement(A, 0, m, B, 0, n, (m+n)/2+1); 
        } else {
            // even: find (m+n)/2 and (m+n)/2+1
            return (findKthElement(A, 0, m, B, 0, n, (m+n)/2) + 
                    findKthElement(A, 0, m, B, 0, n, (m+n)/2+1)) / 2.0;
        }
        
    }
    
    // m and n is the number of elements in array A and B
    public int findKthElement(int A[], int baseA, int m, int B[], int baseB, int n, int k){
        // assume A has less element than B 
        if (m > n) {
            return findKthElement(B, baseB, n, A, baseA, m, k); 
        }
        
        // A has nothing left, return the kth element in B
        if (m == 0) {
            return B[baseB + k - 1];
        }
        
        if (k == 1) {
            // return the smaller one
            return Math.min(A[baseA], B[baseB]);
        }
        
        int indexA = Math.min(k/2, m); 
        int indexB = k - indexA; 
        if(A[baseA + indexA - 1] < B[baseB + indexB - 1]) {
            // 0 ~ indexA is defintely smaller than kth element 
            return findKthElement(A, baseA + indexA, m - indexA, 
                                    B, baseB, n, k - indexA);
        } else if (A[baseA + indexA -1] > B[baseB + indexB - 1]) {
            // 0 ~ indexB is defintely smaller than kth element
            return findKthElement(A, baseA, m, 
                                  B, baseB + indexB, n - indexB, k - indexB);
        } else {
            if (indexA == k/2) {
                // A[k/2 -1] == B[k/2 -1]
                return A[baseA + indexA - 1]; 
            } else {
                return findKthElement(A, baseA + indexA, m - indexA, 
                                        B, baseB, n, k - indexA); 
            }
        }
    }
}