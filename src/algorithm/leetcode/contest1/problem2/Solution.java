package algorithm.leetcode.contest1.problem2;

public class Solution {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'.','.','W','.','B','W','W','B'},
                {'B','W','.','W','.','W','B','B'},
                {'.','W','B','W','W','.','W','W'},
                {'W','W','.','W','.','.','B','B'},
                {'B','W','B','B','W','W','B','.'},
                {'W','.','W','.','.','B','W','W'},
                {'B','.','B','B','.','.','B','B'},
                {'.','W','.','W','.','W','.','W'}};
        System.out.println(solution.checkMove(board, 5, 4, 'W'));
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        return checkGoodLine(board, rMove, cMove);
    }

    public boolean checkGoodLine(char[][] board, int row, int col) {
        char endColor = board[row][col];

        for (int i=0; i<8; i++) {
            int count = 1;
            int nRow = row;
            int nCol = col;

            while(true) {
                nRow = nRow + dy[i];
                nCol = nCol + dx[i];

                if (nRow < 0 || nRow >= board.length || nCol < 0 || nCol >= board.length) {
                    break;
                }

                if (board[nRow][nCol] == '.') {
                    break;
                } else {
                    if (board[nRow][nCol] == endColor) {
                        if (count >= 2) {
                            return true;
                        } else {
                            break;
                        }
                    }
                }

                count++;
            }
        }

        return false;
    }
}
