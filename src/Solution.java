class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k > n / 2) {
            int result = 0;
            for (int i = 1; i < n; i++) {
                result += Math.max(0, prices[i] - prices[i - 1]);
            }
            return result;
        }
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }
        return dp[k][1];
    }
}