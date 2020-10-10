class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !mark[i][j]) {
                    result++;
                    dfs(grid, mark, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] mark, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || mark[row][column] || grid[row][column] == '0') {
            return;
        }
        mark[row][column] = true;
        dfs(grid, mark, row - 1, column);
        dfs(grid, mark, row + 1, column);
        dfs(grid, mark, row, column - 1);
        dfs(grid, mark, row, column + 1);
    }
}