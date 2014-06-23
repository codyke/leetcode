/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. */

public class Solution {
    public int longestConsecutive(int[] num) {
        // Solution O(n)
        int len = num.length;
        int result = 0;
        if(len == 0) {
            return 0;
        }
        Set<Integer> hashset = new HashSet<Integer>(); 
        for(int i = 0; i < len; i++) {
            hashset.add(num[i]); 
        }
        
        for(int i = 0; i < len; i++) {
            int j = num[i]; 
            int tmpRe = 1; 
            if(hashset.contains(j) == false) {
                continue; 
            }
            
            while(hashset.contains(j - 1)) {
                tmpRe++; 
                hashset.remove(j - 1); 
                j--; 
            } 
            
            j = num[i]; 
            while(hashset.contains(j + 1)) {
                tmpRe++; 
                hashset.remove(j + 1); 
                j++; 
            }
            
            hashset.remove(num[i]);
            if(tmpRe > result) {
                result = tmpRe; 
            }
        }
        
        return result;
        
        // Solution O(NlogN)
        /*int len = num.length; 
        if(len == 0) {
            return 0;
        }
        Arrays.sort(num); 
        int result = 1; 
        int conse = 1;
        for(int i = 0; i < len - 1; i++) {
            if(num[i] + 1 == num[i + 1]) {
                conse++; 
                if(conse > result) {
                    result = conse; 
                }
            } else if (num[i] == num[i + 1]) {
                continue; 
            }else {
                conse = 1; 
            }
        }
        return result; */
    }
}