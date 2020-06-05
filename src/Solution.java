class Solution {
    public int numTrees(int n) {
        if (n < 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j > 0; j--) {
                int leftResult = dp[j - 1];
                int rightResult = dp[i - j];
                dp[i] += leftResult * rightResult;
            }
        }
        return dp[dp.length - 1];
    }
}