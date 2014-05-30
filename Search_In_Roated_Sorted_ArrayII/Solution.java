/*Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.*/

public class Solution {
    public boolean search(int[] A, int target) {
        int start = 0; 
        int end = A.length - 1; 
        int middle = (start + end) / 2; 
        if(end < 0) {
            return false;
        }
        boolean flag = false; 
        if (A[0] < A[end]) {
            flag = true; 
        } else if (target >= A[0]) {
            flag = true; 
        } 
        
        do{
            if(A[middle] == target) {
                return true; 
            } else if(target < A[middle]) {
                if(flag) {
                    end = middle - 1; 
                } else {
                    if(A[middle] > A[0]) {
                        start = middle + 1; 
                    } else if (A[middle] < A[0]) {
                        end = middle - 1; 
                    } else if (A[middle] == A[0]) {
                        if(middleInLeft(middle, A)) {
                            start = middle + 1; 
                        } else {
                            end = middle - 1; 
                        }
                    }
                }
            } else if(target > A[middle]){
                if(flag) {
                    if(A[middle] > A[0]) {
                        start = middle + 1; 
                    } else if (A[middle] < A[0]) {
                        end = middle - 1;
                    } else if (A[middle] == A[0]) {
                        if(middleInLeft(middle, A)) {
                            start = middle + 1; 
                        } else {
                            end = middle - 1; 
                        }
                    }
                } else {
                    start = middle + 1; 
                }
            }
            middle = (start + end) / 2;
        } while(start <= end);
        
        return false; 
    }
    
    public boolean middleInLeft(int middle, int[] A) {
        int len = A.length; 
        int i = 0;
        for(i = middle; i > 0; i--) {
            if(A[i] < A[i - 1]) {
                return false; 
            } 
        }
        
        return true; 
    }
}