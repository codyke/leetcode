/*Given an array of integers, every element appears three times except for one. Find that single one. */

public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length;
        if(len < 3) {
            return A[0]; 
        }
        Arrays.sort(A); 
        for(int i = 0; i < len - 3; i += 3){
            if(A[i + 1] != A[i] || A[i + 2] != A[i]) {
                return A[i]; 
            }
        }
        return A[len - 1]; 
    }
}