class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length && s1.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i < dp.length && s2.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = equal(s2, s3, i - 1, i + j - 1);
                }
                if (dp[i][j]) {
                    continue;
                }
                if (dp[i][j - 1]) {
                    dp[i][j] = equal(s1, s3, j - 1, i + j - 1);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private boolean equal(String s1, String s2, int index1, int index2) {
        return s1.charAt(index1) == s2.charAt(index2);
    }
}