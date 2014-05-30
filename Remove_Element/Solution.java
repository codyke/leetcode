/*Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length. */

public class Solution {
    public int removeElement(int[] A, int elem) {
        int end = A.length; 
        int tmp; 
        int i; 
        for(i = 0; i < A.length && i < end; i++) {
            if (A[i] == elem){
                //swap the instance to the end of the array
                while(A[end - 1] == elem && end - 1 > i){
                    end--;
                }
                if (end == i)
                    break;
                tmp = A[end - 1]; 
                A[end - 1] = A[i];
                A[i] = tmp; 
                end--;
            }
        }
        return end;
    }
}