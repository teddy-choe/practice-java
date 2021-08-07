package algorithm.baekjun.tetromino;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = 0;
    static boolean[][] visited;

    static class Point {
        int row;
        int col;
        int point;
        int depth;

        public Point(int row, int col, int point, int depth) {
            this.row = row;
            this.col = col;
            this.point = point;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        matrix = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                bfs(i, j);
            }
        }

        System.out.println(max);
    }

    static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new Point(row, col, matrix[row][col], 1));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.depth == 4) {
                max = Math.max(max, cur.point);
                continue;
            }

            for (int i=0; i<4; i++) {
                int nRow = cur.row + dy[i];
                int nCol = cur.col + dx[i];

                if (nRow < 0 || nRow >= visited.length || nCol < 0 || nCol >= visited[0].length) {
                    continue;
                }

                if (visited[nRow][nCol]) continue;

                int depth = cur.depth + 1;
                int point = cur.point + matrix[nRow][nCol];
                visited[nRow][nCol] = true;

                queue.add(new Point(nRow, nCol, point, depth));
            }
        }

        for (int i=0; i<4; i++) {
            int temp = matrix[row][col];
            for (int j=0; j<4; j++) {
                if (i == j) continue;

                int nRow = row + dy[j];
                int nCol = col + dx[j];

                if (nRow < 0 || nRow >= visited.length || nCol < 0 || nCol >= visited[0].length) {
                    break;
                }

                temp += matrix[nRow][nCol];
                max = Math.max(temp, max);
            }
        }
    }
}
