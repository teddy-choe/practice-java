package algorithm.programmers.walker_heaven;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] map = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        solution.solution(3, 6, map);
    }

    class Point {
        int row;
        int col;
        int dir;

        public Point(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    int MOD = 20170805;
    int count = 0;
    int[] dx = {1, 0};
    int[] dy = {0, 1};

    public int solution(int m, int n, int[][] cityMap) {

        bfs(cityMap, m, n);

        return count;
    }

    void bfs(int[][] cityMap, int totalRow, int totalCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, -1));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.row == totalRow - 1 && cur.col == totalCol - 1) {
                count = (count + 1) % MOD;
                continue;
            }

            if (cityMap[cur.row][cur.col] == 2) {
                int nRow = cur.row + dy[cur.dir];
                int nCol = cur.col + dx[cur.dir];

                if (nRow < 0 || nRow >= totalRow || nCol < 0 || nCol >= totalCol) continue;

                queue.add(new Point(nRow, nCol, cur.dir));
                continue;
            }

            for (int i = 0; i < 2; i++) {
                int nRow = cur.row + dy[i];
                int nCol = cur.col + dx[i];

                if (nRow < 0 || nRow >= totalRow || nCol < 0 || nCol >= totalCol) continue;

                if (cityMap[nRow][nCol] == 1) {
                    continue;
                }

                queue.add(new Point(nRow, nCol, i));
            }
        }
    }
}
