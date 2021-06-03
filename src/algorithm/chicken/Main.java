package algorithm.chicken;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int minDis = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] selectStore;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
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
        int m = scanner.nextInt();
        map = new int[n][n];
        selectStore = new boolean[n][n];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        backTracking(0, m);

        System.out.println(minDis);
    }

    public static void backTracking(int index, int m) {
        int n = map.length;

        if (index == m) {
            int disSum = 0;

            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (map[i][j] == 1) {
                        disSum += distance(i, j);
                    }
                }
            }

            if (minDis > disSum) {
                minDis = disSum;
            }

            return;
        }

        // 2d array에서 조합하는 방법을 찾아보기
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (map[i][j] == 2 && !selectStore[i][j]) {
                    selectStore[i][j] = true;
                    backTracking(index+1, m);
                    selectStore[i][j] = false;
                }
            }
        }

    }

    public static int distance(int row, int col) {
        int n = map.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col, 0));

        while (!queue.isEmpty()){
            Point temp = queue.poll();

            if (map[temp.row][temp.col] == 2 && selectStore[temp.row][temp.col]) {
                return temp.depth;
            }

            for (int i=0; i<4; i++) {
                int nRow = temp.row + dy[i];
                int nCol = temp.col + dx[i];

                if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= n) {
                    continue;
                }

                if (!visited[nRow][nCol]) {
                    queue.add(new Point(nRow, nCol, temp.depth + 1));
                }
            }
        }

        return 0;
    }
}
