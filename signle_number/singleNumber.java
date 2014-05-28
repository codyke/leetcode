/*Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/ 

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        int i = 0;
        for (i = 0; i < A.length; i++) {
            if (mymap.containsKey(A[i])) {
                mymap.remove(A[i]);
            } else {
                mymap.put(A[i], 1);
            }
        }
        return mymap.entrySet().iterator().next().getKey();
    }
}