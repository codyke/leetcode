/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
    The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

import java.lang.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num); 
        int p1 = 0; 
        int p2 = 0; 
        int p3 = 0; 
        int p4 = 0; 
        int len = num.length; 
        int remain = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        for(; p1 < len - 3; p1++){
            if(p1 > 0 && num[p1] == num[p1 - 1]){
                continue; 
            }
            for(p2 = p1 + 1; p2 < len - 2; p2++){
                if(p2 > p1 + 1 && num[p2] == num[p2 - 1]) {
                    continue;
                }
                p3 = p2 + 1; 
                p4 = len - 1; 
                remain = target - num[p1] - num[p2]; 
                while(p3 < p4) {
                    if(p3 > p2 + 1 && num[p3] == num[p3 - 1]) {
                        p3++;
                        continue;
                    } 
                    if(p4 < len - 1 && num[p4] == num[p4 + 1]){
                        p4--;
                        continue; 
                    }
                    if(num[p3] + num[p4] > remain) {
                        p4--;
                    } else if (num[p3] + num[p4] < remain){
                        p3++; 
                    } else {
                        // find one
                        ArrayList<Integer> list = new ArrayList<Integer>(); 
                        list.add(num[p1]); 
                        list.add(num[p2]);
                        list.add(num[p3]);
                        list.add(num[p4]);
                        result.add(list); 
                        p3++;
                    }
                }
            }
        }
        return result; 
    }
}