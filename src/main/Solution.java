package main;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 0) {
            return result;
        }
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            } else {
                int earn = prices[i] - minValue;
                result = Math.max(earn, result);
            }
        }
        return result;
    }
}