package algorithm.baekjun.baby_shark2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int size = 2;
    static int count = 0;
    static int time = 0;
    static int sharkX = 0;
    static int sharkY = 0;

    public static class Point {
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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        map = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = scanner.nextInt();

                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                }
            }
        }

        while (true) {
            Point toMove = bfs(sharkY, sharkX);

            if (toMove == null) {
                System.out.println(time);
                return;
            }

            map[toMove.row][toMove.col] = 0;
            count++;
            time += toMove.depth;
            sharkY = toMove.row;
            sharkX = toMove.col;

            if (count == size) {
                size++;
                count = 0;
            }
        }
    }

    public static Point bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[map.length][map.length];
        //shark point
        queue.add(new Point(row, col, 0));

        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            if (map[temp.row][temp.col] != 0 && map[temp.row][temp.col] < size) {
                return temp;
            }

            for (int i=0; i<4; i++) {
                int nRow = temp.row + dy[i];
                int nCol = temp.col + dx[i];

                if (nRow < 0 || nCol < 0 || nRow >= map.length || nCol >= map.length) {
                    continue;
                }

                if (!visited[nRow][nCol]) {
                    if (map[nRow][nCol] > size) {
                        continue;
                    }

                    queue.add(new Point(nRow, nCol, temp.depth+1));
                    visited[nRow][nCol] = true;
                }
            }
        }

        return null;
    }
}
