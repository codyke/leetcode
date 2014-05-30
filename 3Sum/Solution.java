/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

import java.lang.*; 

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num); 
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        int i = 0;
        int j = 0; 
        int k = 0; 
        for(i = 0; i < num.length; i++) {
            if(num[i] > 0) {
                // all nums are positive
                break;
            }
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
                if( sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    // found
                    ArrayList<Integer> answer = new ArrayList<Integer>(); 
                    answer.add(num[i]); 
                    answer.add(num[j]); 
                    answer.add(num[k]); 
                    result.add(answer); 
                    j++; 
                }
            }
        }
        return result; 
    }
}