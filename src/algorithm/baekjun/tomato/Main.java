package algorithm.baekjun.tomato;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] maps;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int col = scanner.nextInt();
        int row = scanner.nextInt();

        maps = new int[row][col];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maps[i][j] = scanner.nextInt();

                if (maps[i][j] == 1) queue.add(new Node(i, j, 0));
            }
        }

        int result = bfs(queue);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);
    }


    static int bfs(Queue<Node> paraQueue) {
        int result = 0;
        Queue<Node> queue = paraQueue;

        while (!queue.isEmpty()) {
            Node curTomato = queue.poll();

            if (curTomato.depth > result) result = curTomato.depth;

            for (int i = 0; i < 4; i++) {
                int nRow = curTomato.row + dy[i];
                int nCol = curTomato.col + dx[i];

                if (nRow < 0 || nRow >= maps.length ||
                        nCol < 0 || nCol >= maps[0].length) {
                    continue;
                }

                if (maps[nRow][nCol] == 0) {
                    maps[nRow][nCol] = 1;
                    queue.add(new Node(nRow, nCol, curTomato.depth + 1));
                }
            }
        }

        return result;
    }
}
