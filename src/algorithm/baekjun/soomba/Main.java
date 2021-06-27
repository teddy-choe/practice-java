package algorithm.baekjun.soomba;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int min = 0;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        moveBfs(n, k);

        System.out.println(min);
    }

    // select one of move x+1, x-1, 2*x
    static void move(int x, int count, int k) {
        if (x < 0 || x > 100000) {
            return;
        }

        visited[x] = true;

        if (x == k) {
            if (min > count) {
                min = count;
            }

            return;
        }

        if (!visited[x+1]) move(x+1, count+1, k);
        if (!visited[x-1]) move(x-1, count+1, k);
        if (!visited[x*2]) move(x*2, count+1, k);
    }

    static void moveBfs(int x, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int curX = point[0];

            if (curX == k) {
                min = point[1];
                return;
            }

            visited[curX] = true;

            if (check(curX+1)) {
                queue.add(new int[]{curX+1, point[1]+1});
            }
            if (check(curX-1)) {
                queue.add(new int[]{curX-1, point[1]+1});
            }
            if (check(curX*2)) {
                queue.add(new int[]{curX*2, point[1]+1});
            }
        }
    }

    static boolean check(int x) {
        if (x < 0 || x > 100000 || visited[x]) {
            return false;
        }

        return true;
    }
}
