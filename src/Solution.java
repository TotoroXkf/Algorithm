class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row][column];
        if (dungeon[row - 1][column - 1] < 0) {
            dp[row - 1][column - 1] = Math.abs(dungeon[row - 1][column - 1]) + 1;
        } else {
            dp[row - 1][column - 1] = 1;
        }
        for (int i = row - 2; i > -1; i--) {
            dp[i][column - 1] = Math.max(dp[i + 1][column - 1] - dungeon[i][column - 1], 1);
        }
        for (int i = column - 2; i > -1; i--) {
            dp[row - 1][i] = Math.max(dp[row - 1][i + 1] - dungeon[row - 1][i], 1);
        }
        for (int i = row - 2; i > -1; i--) {
            for (int j = column - 2; j > -1; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}