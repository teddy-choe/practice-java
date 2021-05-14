package algorithm.testt;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Point {
        int row;
        int col;
        int depth;

        public Point(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Solution main = new Solution();

        int[][] maps = {{1, 28, 41, 22, 25, 79, 4},
                {39, 20, 10, 17, 19, 18, 8},
                {21, 4, 13, 12, 9, 29, 19},
                {58, 1, 20, 5, 8, 16, 9},
                {5, 6, 15, 2, 39, 8, 29},
                {39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}};

        main.solution(maps, 19, 6);
    }

    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private boolean[][] visited;

    public int solution(int[][] maps, int p, int r) {
        int max = 0;

        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps.length; j++) {
                visited = new boolean[maps.length][maps.length];
                int count = bfs(i,j,maps,p,r);

                if (count > max) {
                    max = count;
                }
            }
        }

        System.out.println(max);

        return max;
    }

    public int bfs(int row, int col, int[][] maps, int p, int r) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col, r/2));
        visited[row][col] = true;

        if (row+1 < maps.length) {
            q.add(new Point(row+1, col, r/2));
            visited[row+1][col] = true;
        }

        if (col+1 < maps.length) {
            q.add(new Point(row, col+1, r/2));
            visited[row][col+1] = true;
        }


        if (row+1 < maps.length && col+1 < maps.length) {
            q.add(new Point(row+1, col+1, r/2));
            visited[row+1][col+1] = true;
        }

        int count = 0;

        while (!q.isEmpty()) {
            Point temp = q.poll();

            visited[temp.row][temp.col] = true;

            if (temp.depth > 1 && maps[temp.row][temp.col] <= p) {
                count++;
            } else if (temp.depth <= 1 && maps[temp.row][temp.col] <= p/2) {
                count++;
            }

            for (int i=0; i<4; i++) {
                int nextRow = temp.row + dy[i];
                int nextCol = temp.col + dx[i];

                if (nextRow < 0 || nextCol <0 || nextRow >= visited.length || nextCol >= visited.length || visited[nextRow][nextCol]) {
                    continue;
                }

                if (temp.depth > 1) {
                    q.add(new Point(nextRow,nextCol,temp.depth-1));
                }
            }
        }

        return count;
    }
}
