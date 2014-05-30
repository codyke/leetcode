/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.lang.*;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num); 
        int result = 0; 
        int distance = Integer.MAX_VALUE;
        int i = 0;
        int j = 0; 
        int k = 0; 
        for(i = 0; i < num.length; i++) {
            if(i > 0 && num[i] == num[i - 1]){
                continue;
            }
            j = i + 1; 
            k = num.length - 1; 
            while(j < k){
                if(j > i + 1 && num[j] == num[j - 1]){
                    j++;
                    continue; 
                }
                if(k < num.length - 1 && num[k] == num[k + 1]) {
                    k--;
                    continue; 
                }
                int sum = num[i] + num[j] + num[k];
                if( sum > target) {
                    if(distance > (sum - target)){
                        distance = sum - target; 
                        result = sum; 
                    }
                    k--;
                } else if (sum < target) {
                    if(distance > (target - sum)){
                        distance = target - sum; 
                        result = sum; 
                    }
                    j++;
                } else {
                    return target; 
                }
            }
        }
        return result; 
    }
}