class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        }
        for (int i = 1; i < s.length(); i++) {
            int currentCharNum = s.charAt(i) - '0';
            int preCharNum = s.charAt(i - 1) - '0';
            if (preCharNum > 0 && preCharNum * 10 + currentCharNum <= 26) {
                dp[i + 1] += dp[i - 1];
            }
            if (currentCharNum != 0) {
                dp[i + 1] += dp[i];
            }
        }
        return dp[dp.length - 1];
    }
}