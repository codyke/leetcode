/* Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]. */

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0; 
        }
        int cur = 0; 
        int next = cur + 1; 
        int record = A[cur];
        int firstDup = 0;
        while(cur < next && next < A.length) {
            if (A[cur] < A[next]) {
                if (cur + 1 < next) {
                    A[cur + 1] = A[next];
                }
                cur++;
                next++;
                if (A[cur] != record) {
                    record = A[cur];
                    firstDup = 0;
                }
            } else if (A[cur] == A[next]) {
                if (firstDup == 0) {
                    firstDup++;
                    if (cur + 1 < next) {
                        A[cur + 1] = A[next]; 
                    }
                    cur++;
                    next++;
                } else {
                    next++;
                }
            }
        }
        return cur + 1;
    }
}