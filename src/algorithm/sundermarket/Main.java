package algorithm.sundermarket;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] matrix;
    static boolean[][] visited;
    static int minDepth = 0;
    static int minHorizontalMove = 0;
    static int w;
    static int h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        w = scanner.nextInt();
        h = scanner.nextInt();

        scanner.nextLine();

        matrix = new char[h][w];
        Queue<Node> startQueue = new LinkedList<>();

        for (int i=0; i<h; i++) {
            String temp = scanner.nextLine();
            for (int j=0; j<w; j++) {
                matrix[i][j] = temp.charAt(j);
                if (temp.charAt(j) == 'c') {
                    startQueue.add(new Node(i, j, 0, 0));
                }
            }
        }

        while (!startQueue.isEmpty()) {
            Node startNode = startQueue.poll();
            visited = new boolean[h][w];
            bfs(startNode.y, startNode.x);
        }

        System.out.println(minHorizontalMove);
    }

    public static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, 1, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.y][node.x] = true;
            x = node.x;
            y = node.y;

            if (node.x - 1 >= 0) {
                if (matrix[y][x - 1] == '.' && visited[y][x - 1] == false) {
                    queue.add(new Node(node.y,node.x - 1, node.depth + 1, node.horizontalMove + 1));
                }
            }

            if (node.x + 1 < w) {
                if (matrix[y][x + 1] == '.' && visited[y][x + 1] == false) {
                    queue.add(new Node(node.y,node.x + 1, node.depth + 1, node.horizontalMove + 1));
                }
            }

            if (node.y + 1 < h) {
                if (matrix[y + 1][x] == '.' && visited[y + 1][x] == false) {
                    queue.add(new Node(node.y + 1, node.x, node.depth + 1, node.horizontalMove));
                }
            }

            if (node.y == h-1) {
                if (minDepth == 0 || minDepth > node.depth) {
                    minDepth = node.depth;
                    minHorizontalMove = node.horizontalMove;
                }

                break;
            }
        }
    }

    static class Node {
        int x;
        int y;
        int depth;
        int horizontalMove;

        Node(int y, int x, int depth, int horizontalMove) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.horizontalMove = horizontalMove;
        }
    }
}
