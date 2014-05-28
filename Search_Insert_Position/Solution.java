/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0 */

public class Solution {
    public int searchInsert(int[] A, int target) {
        int i = 0; 
        for(i = 0; i < A.length; i++) {
            if (target == A[i]){
                return i;
            } else if (target > A[i]) {
                continue;
            } else {
                return i;
            }
        }
        return i;
    }
}