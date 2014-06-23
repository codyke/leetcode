/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.*/

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0; 
        }
        
        int[] left = new int[len]; 
        int[] right = new int[len]; 
        int result = 0; 
        
        int min = prices[0]; 
        for(int i = 1; i < len; i++) {
            if(prices[i] - min > left[i - 1]) {
                left[i] = prices[i] - min; 
            } else {
                left[i] = left[i - 1]; 
            }
            if(min > prices[i]) {
                min = prices[i]; 
            }
        }
        int max = prices[len - 1]; 
        for(int i = len - 2; i >= 0; i--) {
            if(max - prices[i] > right[i + 1]) {
                right[i] = max - prices[i]; 
            } else {
                right[i] = right[i + 1]; 
            }
            if(max < prices[i]) {
                max = prices[i]; 
            }
        }
        for(int i = 0; i < len; i++) {
            if(left[i] + right[i] > result) {
                result = left[i] + right[i];
            }
        }
        return result;
    }
}