/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/

public class Solution {
    public int search(int[] A, int target) {
        int start = 0; 
        int end = A.length - 1; 
        int middle = (start + end) / 2; 
        if(end < 0) {
            return -1;
        }
        boolean flag = false; 
        if (A[0] < A[end]) {
            flag = true; 
        } else if (target >= A[0]) {
            flag = true; 
        }
        
        do{
            if(A[middle] == target) {
                return middle; 
            } else if(target < A[middle]) {
                if(flag || A[middle] < A[0]) {
                    end = middle - 1; 
                } else if (A[middle] >= A[0]) {
                    start = middle + 1; 
                }
            } else if(target > A[middle]){
                if(!flag || A[middle] >= A[0]) {
                    start = middle + 1; 
                } else if (A[middle] < A[0] ) {
                    end = middle - 1;
                }
            }
            middle = (start + end) / 2;
        } while(start <= end);
        
        return -1; 
    }
}