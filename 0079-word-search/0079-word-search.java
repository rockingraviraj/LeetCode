class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], '.');
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (Solve(board, word, map, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean SafePlace(char[][] board,char[][] map,int row,int col,char value) {

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (map[row][col] == 'Q') {
            return false;
        }

        if (board[row][col] != value) {
            return false;
        }

        return true;
    }

    public static boolean Solve(char[][] board,String word,char[][] map,int row,int col,int index) {

        // Word complete
        if (index == word.length()) {
            return true;
        }

        // Safe check
        if (!SafePlace(board, map, row, col, word.charAt(index))) {
            return false;
        }

        // Choose
        map[row][col] = 'Q';
        // Recursion: 4 directions

        if (Solve(board, word, map, row, col + 1, index + 1) ||
            Solve(board, word, map, row, col - 1, index + 1) ||
            Solve(board, word, map, row + 1, col, index + 1) ||
            Solve(board, word, map, row - 1, col, index + 1)) {

            return true;
        }

        // Backtrack
        map[row][col] = '.';

        return false;
    }
}