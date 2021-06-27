package algorithm.baekjun.prime_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int number;
        int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i=0; i<n; i++) {
            visited = new boolean[10000];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int result = bfs(
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()));
            if (result == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(result);
            }
        }
    }

    public static int bfs(int num, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(num, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            visited[cur.number] = true;

            if (cur.number == target) return cur.count;

            int thousand = cur.number / 1000;
            int hundred = (cur.number % 1000) / 100;
            int ten = (cur.number % 100) / 10;
            int one = cur.number % 10;

            for (int i=0; i<4; i++) {
                for (int j=0; j<10; j++) {
                    // 첫째 자리가 0이 오면 안된다
                    if (i == 0 && j == 0) continue;

                    int toNum = 0;

                    if (i == 0) {
                        toNum = j*1000 + hundred * 100 + ten * 10 + one;
                    }

                    if (i == 1) {
                        toNum = thousand*1000 + j * 100 + ten * 10 + one;
                    }

                    if (i == 2) {
                        toNum = thousand*1000 + hundred * 100 + j * 10 + one;
                    }

                    if (i == 3) {
                        toNum = thousand*1000 + hundred * 100 + ten * 10 + j;
                    }

                    if (!visited[toNum] && isPrimeNumber(toNum)) {
                        queue.add(new Node(toNum, cur.count+1));
                    }
                }
            }
        }

        return -1;
    }

    static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        // 짝수는 소수가 아니다.
        if (number % 2 == 0) {
            return false;
        }

        for (int i=2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
