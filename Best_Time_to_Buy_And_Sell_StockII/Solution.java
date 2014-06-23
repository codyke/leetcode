/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] deltaPrice = new int[len];
        int i = 0;
        for(i = 0; i < len -1; i++) {
            deltaPrice[i] = prices[i + 1] - prices[i];
        }
        
        int maxProfit = 0;
        int tmpSum = 0;
        for(i = 0; i < len - 1; i++) {
            if(deltaPrice[i] < 0) {
                maxProfit += tmpSum; 
                tmpSum = 0; 
                continue; 
            } else {
                tmpSum += deltaPrice[i]; 
            }
        }
        if(tmpSum > 0) {
            maxProfit += tmpSum; 
        }
        return maxProfit;
    }
}