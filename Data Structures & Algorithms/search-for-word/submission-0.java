class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {

                    visited[i][j] = true;

                    if (solve(0, i, j, board, word, visited))
                        return true;

                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean solve(int curr, int i, int j,
                          char[][] board,
                          String word,
                          boolean[][] visited) {

        // Entire word matched
        if (curr == word.length() - 1)
            return true;

        // UP
        if (i - 1 >= 0 &&
            !visited[i - 1][j] &&
            board[i - 1][j] == word.charAt(curr + 1)) {

            visited[i - 1][j] = true;

            if (solve(curr + 1, i - 1, j, board, word, visited))
                return true;

            visited[i - 1][j] = false;
        }

        // LEFT
        if (j - 1 >= 0 &&
            !visited[i][j - 1] &&
            board[i][j - 1] == word.charAt(curr + 1)) {

            visited[i][j - 1] = true;

            if (solve(curr + 1, i, j - 1, board, word, visited))
                return true;

            visited[i][j - 1] = false;
        }

        // DOWN
        if (i + 1 < board.length &&
            !visited[i + 1][j] &&
            board[i + 1][j] == word.charAt(curr + 1)) {

            visited[i + 1][j] = true;

            if (solve(curr + 1, i + 1, j, board, word, visited))
                return true;

            visited[i + 1][j] = false;
        }

        // RIGHT
        if (j + 1 < board[0].length &&
            !visited[i][j + 1] &&
            board[i][j + 1] == word.charAt(curr + 1)) {

            visited[i][j + 1] = true;

            if (solve(curr + 1, i, j + 1, board, word, visited))
                return true;

            visited[i][j + 1] = false;
        }

        return false;
    }
}