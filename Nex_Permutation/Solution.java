/* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1*/

import java.lang.*; 

public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length; 
        int i; 
        int k; 
        int tmp; 
        for(i = len - 1; i > 0; --i) {
            if(num[i] > num[i - 1]) {
                break; 
            }
        }
        if(i > 0) {
            Arrays.sort(num, i, len); 
            for(k = i; k < len - 1; ++k) {
                if(num[k] > num[i - 1]) {
                    break;
                }
            }
            tmp = num[k]; 
            num[k] = num[i - 1]; 
            num[i - 1] = tmp; 
        } else {
            Arrays.sort(num);             
        }
    }
}