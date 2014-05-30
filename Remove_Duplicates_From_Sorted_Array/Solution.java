/* Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]. */

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int cur = 0;
        int next = cur + 1; 
        int length = A.length;
        while(cur < length && next < length) {
            if (A[cur] < A[next]){
                if (cur + 1 < next){
                    A[cur + 1] = A[next];
                }
                cur++;
                next++;
            } else if (A[cur] == A[next])
                next++;
        }
        return cur + 1;
    }
}