/*The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/

public class Solution {
    public String getPermutation(int n, int k) {
        int[] table = new int[n + 1]; 
        int[] record = new int[n + 1]; 
        int[] result = new int[n + 1]; 
        table[0] = 0; 
        table[1] = 1;
        record[0] = 0; 
        record[1] = 0;
        for(int i = 2; i < n + 1; i++) {
            table[i] = i * table[i - 1]; 
            record[i] = 0; 
        }
        
        permutation(table, record, k, 1, n, result);
        String ans = ""; 
        for(int i = 1; i < n + 1; i++) {
        	ans += Character.toString((char) (result[i] + '0')); 
        } 
        return ans; 
    }
    
    public void permutation(int[] table, int[] record, int k, int cur, int n, int[] result) {
        if(n < cur) {
            return; 
        }
        // do we need to continue? 
        int leftBit = n - cur; 
        int num = leftBit == 0 ? 1 : table[n - cur]; 
        int index = 1; 
        while(index < record.length) {
            if(record[index] == 0) {
                if(record[0] + num < k) {
                    record[0] += num; 
                } else {
                    record[index] = 1; 
                    result[cur] = index; 
                    if(cur == n) {
                        record[0]++; 
                    }
                    permutation(table, record, k, cur + 1, n, result); 
                    if(record[0] == k) {
                        return; 
                    } else {
                        record[index] = 0; 
                    }
                }
               
            }
            index++;
        }
    }
}