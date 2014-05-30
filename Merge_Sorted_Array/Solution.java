/*Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int num = m + n;
        int Pa = m - 1;
        int Pb = n - 1;
        int P = num - 1;
        if (num != 0) {
            while (Pa >= 0 && Pb >= 0) {
                if (A[Pa] < B[Pb]) {
                    A[P--] = B[Pb--];
                } else {
                    A[P--] = A[Pa--];
                }
            }
            while(Pa >= 0) {
                A[P--] = A[Pa--];
            }
            while(Pb >= 0) {
                A[P--] = B[Pb--];
            }
        }
    }
}