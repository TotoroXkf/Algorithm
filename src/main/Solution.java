package main;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 0) {
            return result;
        }
        int preValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (preValue <= prices[i]) {
                result += prices[i] - preValue;
            }
            preValue = prices[i];
        }
        return result;
    }
}