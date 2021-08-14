package algorithm.programmers.little_four;

import java.util.HashSet;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public String solution(int m, int n, String[] board) {
        String answer = "";

        char[][] charBoard = new char[m][n];
        HashSet<Character> hashSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                char c = board[i].charAt(j);
                charBoard[i][j] = c;

                if (c != '.' && c != '*') hashSet.add(c);
            }
        }

        int[][] targetList = new int[hashSet.size()][2];

        return answer;
    }

    boolean searchTarget(char target, char[][] board, int row, int col)  {
        for (int i=0; i<4; i++) {
            int nRow = row;
            int nCol = col;

            while (nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length) {
                nRow += dy[i];
                nCol += dx[i];

                if (board[nRow][nCol] == target) return true;

                if (board[nRow][nCol] != '.') break;

                for (int j=(i+1)%2; j<4; j += 2) {
                    int secondRow = nRow;
                    int secondCol = nCol;

                    while (secondRow >= 0 && secondRow < board.length
                            && secondCol >= 0 && secondCol < board[0].length) {
                        secondRow += dy[i];
                        secondCol += dx[i];

                        if (board[secondRow][secondCol] == target) return true;

                        if (board[secondRow][secondCol] != '.') break;
                    }
                }
            }
        }

        return false;
    }
}
