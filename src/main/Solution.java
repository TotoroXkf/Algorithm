package main;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int max = 0;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            leftMin = Math.min(prices[i], leftMin);
            max = Math.max(prices[i] - leftMin, max);
            left[i] = max;
        }

        max = 0;
        int[] right = new int[prices.length];
        int rightMax = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i > -1; i--) {
            rightMax = Math.max(rightMax, prices[i]);
            max = Math.max(rightMax - prices[i], max);
            right[i] = max;
        }

        max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(left[i] + right[i], max);
        }

        return max;
    }
}