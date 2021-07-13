package algorithm.baekjun.create_bridge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        int row;
        int col;
        int depth;

        public Node(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int[][] maps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int islandIndex = 2;

        int n = scanner.nextInt();
        maps = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = scanner.nextInt();
            }
        }

        // 대륙별 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    checkIsland(i, j, islandIndex++);
                }
            }
        }

        int min = 10000;
        // 대륙별 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] != 0) {
                    min = Math.min(min, checkDistance(i, j, maps[i][j], new boolean[n][n]));
                }
            }
        }

        System.out.println(min);
    }

    static void checkIsland(int row, int col, int index) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col, 0));
        maps[row][col] = index;
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dy[i];
                int nCol = cur.col + dx[i];

                if (nRow < 0 || nRow >= visited.length ||
                        nCol < 0 || nCol >= visited.length) continue;

                if (!visited[nRow][nCol] && maps[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    queue.add(new Node(nRow, nCol, 0));
                    maps[nRow][nCol] = index;
                }
            }
        }
    }

    static int checkDistance(int row, int col, int index, boolean[][] visitedDistance) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col, 0));
        visitedDistance[row][col] = true;
        int dis = 10000;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (maps[cur.row][cur.col] != index && maps[cur.row][cur.col] != 0) {
                dis = Math.min(dis, cur.depth - 1);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dy[i];
                int nCol = cur.col + dx[i];

                if (nRow < 0 || nRow >= visitedDistance.length ||
                        nCol < 0 || nCol >= visitedDistance.length) continue;

                if (!visitedDistance[nRow][nCol] && maps[nRow][nCol] != index) {
                    visitedDistance[nRow][nCol] = true;
                    queue.add(new Node(nRow, nCol, cur.depth + 1));
                }
            }
        }

        return dis;
    }
}
