/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.*/

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] deltaPrice = new int[len];
        int i = 0;
        for(i = 0; i < len -1; i++) {
            deltaPrice[i] = prices[i + 1] - prices[i];
        }
        
        //find the max sum of the sequencial num in deltaPrice
        int maxProfit = 0;
        int tmpSum = 0;
        for(i = 0; i < len - 1; i++) {
            if (tmpSum + deltaPrice[i] < 0) {
                tmpSum = 0;
            } else {
                tmpSum += deltaPrice[i];
                if (tmpSum > maxProfit) {
                    maxProfit = tmpSum;
                }
            }
        }
        return maxProfit;
    }
}