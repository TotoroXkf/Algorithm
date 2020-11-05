public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[i] = 1;
                result = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            int leftTopValue = dp[0];
            dp[0] = 0;
            if (matrix[i][0] == '1') {
                dp[0] = 1;
                result = Math.max(result, 1);
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    leftTopValue = dp[j];
                    dp[j] = 0;
                    continue;
                }
                int temp = dp[j];
                dp[j] = Math.min(leftTopValue, Math.min(dp[j - 1], dp[j])) + 1;
                leftTopValue = temp;
                result = Math.max(result, dp[j] * dp[j]);
            }
        }
        return result;
    }
}