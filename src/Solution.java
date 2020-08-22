class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i, mark);
            dfs(board, board.length - 1, i, mark);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0, mark);
            dfs(board, i, board[0].length - 1, mark);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !mark[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int column, boolean[][] mark) {
        if (row < 0 || row >= board.length) {
            return;
        }
        if (column < 0 || column >= board[0].length) {
            return;
        }
        if (board[row][column] == 'X' || mark[row][column]) {
            return;
        }
        mark[row][column] = true;
        dfs(board, row + 1, column, mark);
        dfs(board, row - 1, column, mark);
        dfs(board, row, column + 1, mark);
        dfs(board, row, column - 1, mark);
    }
}