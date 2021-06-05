package algorithm.race_construct;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class State {
        int row;
        int col;
        int dir;
        int cost;

        public State(int row, int col, int dir, int cost) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public boolean[][] visited;
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(solution.solution(board));
    }

    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length];
        bfs(board);

        return minCost;
    }

    private void bfs(int[][] map) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, -1, 100));

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            visited[cur.row][cur.col] = true;

            if (cur.row == map.length-1 && cur.col == map.length-1) {
                if (minCost > cur.cost) {
                    minCost = cur.cost;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dy[i];
                int nCol = cur.col + dx[i];

                if (nRow < 0 || nCol < 0 || nRow >= map.length || nCol >= map.length) {
                    continue;
                }

                if (!visited[nRow][nCol] && map[nRow][nCol] != 1) {
                    int cost = 0;

                    if (cur.dir == -1) {
                        cost = cur.cost + 100;
                    } else if (Math.abs(cur.dir - i) % 2 == 1) {
                        // 방향 직교
                        cost = cur.cost + 500;
                    } else {
                        cost = cur.cost + 100;
                    }

                    queue.add(new State(nRow,nCol,i,cost));
                }
            }
        }
    }
}
