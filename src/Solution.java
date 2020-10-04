class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxProfit(prices, k, 0);
    }

    private int maxProfit(int[] prices, int k, int index) {
        if (index >= prices.length || k == 0) {
            return 0;
        }
        int result = 0;
        int i = index;
        while (i < prices.length) {
            int j = i + 1;
            while (j < prices.length && prices[j] > prices[j - 1]) {
                j++;
            }
            j--;
            if (i == j) {
                i++;
                continue;
            }
            int earn = prices[j] - prices[i];
            int nextEarn = maxProfit(prices, k - 1, j + 1);
            result = Math.max(result, earn + nextEarn);
            i = j + 1;
        }
        return result;
    }
}