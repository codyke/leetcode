/* Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. */

public class Solution {
    public void sortColors(int[] A) {
        //Best solution 
        int p0 = 0;
        int p1 = 0; 
        int p2 = 0;
        int i = 0;
        for(i = 0; i < A.length; i++){
            if (A[i] == 0) {
                A[p2++] = 2;
                A[p1++] = 1;
                A[p0++] = 0;
            } else if (A[i] == 1) {
                A[p2++] = 2;
                A[p1++] = 1;
            } else if (A[i] == 2) {
                A[p2++] = 2;
            }
        }
        
        /*myQuickSort(A, 0, A.length - 1);*/
    }
    
    /*public void myQuickSort(int[] A, int left, int right) {
        //quick sort
        //basic case
        if (left >= right) {
            return;
        }
        //pick the middle number as the pivot
        int pivot = (right + left) / 2;
        //switch the middle number with the last one
        int tmp = A[right];
        A[right] = A[pivot];
        A[pivot] = tmp;
        //begin sort
        int p1 = 0; 
        int p2 = right - 1;
        while(p2 >= p1) {
            while(A[p1] <= A[right] && p1 < p2) 
                p1++;
            while(A[p2] >= A[right] && p1 < p2)
                p2--;
            if (p1 == p2) {
                //finish one iteration, switch the pivot to right place
                pivot = right;
                if (A[p2] > A[right]) {
                    tmp = A[p2];
                    A[p2] = A[right];
                    A[right] = tmp;
                    pivot = p2;
                }
                break;
            } else {
                //switch A[p1] and A[p2]
                tmp = A[p2];
                A[p2] = A[p1];
                A[p1] = tmp;
            }
        }
        
        //sort left part
        myQuickSort(A, 0, pivot - 1);
        //sort right part
        myQuickSort(A, pivot + 1, right);
    }*/
}