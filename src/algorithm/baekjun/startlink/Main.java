package algorithm.baekjun.startlink;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        int floor;
        int count;

        public Node(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }
    }

    static boolean[] visited;
    static int total;
    static int up;
    static int down;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        total = scanner.nextInt();
        int s = scanner.nextInt();
        int g = scanner.nextInt();
        up = scanner.nextInt();
        down = scanner.nextInt();

        visited = new boolean[total+1];

        int result = bfs(s,g);

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result+1);
        }
    }

    public static int bfs(int start, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.floor == target) {
                return cur.count;
            }

            int upFloor = cur.floor + up;
            int downFloor = cur.floor + down;

            if (upFloor > 0 && upFloor <= total) {
                if (!visited[upFloor]) {
                    visited[upFloor] = true;
                    queue.add(new Node(upFloor, cur.count+1));
                }
            }

            if (downFloor > 0 && downFloor <= total) {
                if (!visited[downFloor]) {
                    visited[downFloor] = true;
                    queue.add(new Node(downFloor, cur.count+1));
                }
            }
        }

        return -1;
    }
}
