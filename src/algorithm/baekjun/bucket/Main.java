package algorithm.baekjun.bucket;

import java.util.*;

public class Main {
    static class Bucket {
        int a;
        int b;
        int c;

        public Bucket(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static boolean[][][] visited = new boolean[201][201][201];
    static Set<Integer> results = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        bfs(a,b,c);

        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    static void bfs(int limitA, int limitB, int limitC) {
        Queue<Bucket> queue = new LinkedList<>();
        queue.add(new Bucket(0, 0, limitC));
        visited[0][0][limitC] = true;

        while (!queue.isEmpty()) {
            Bucket cur = queue.poll();

            if (cur.a == 0) {
                results.add(cur.c);
            }

            // a 이동
            if (cur.a != 0) {
                //a에서 b로 넣는 경우
                if (cur.a > (limitB - cur.b)) {
                    int a = cur.a - (limitB - cur.b);
                    int b = limitB;

                    if (!visited[a][b][cur.c]) {
                        visited[a][b][cur.c] = true;
                        queue.add(new Bucket(a, b, cur.c));
                    }
                } else {
                    int a = 0;
                    int b = cur.b + cur.a;
                    if (!visited[a][b][cur.c]) {
                        visited[a][b][cur.c] = true;
                        queue.add(new Bucket(a, b, cur.c));
                    }
                }

                //a에서 c로
                if (cur.a > (limitC - cur.c)) {
                    int a = cur.a - (limitC - cur.c);
                    int c = limitC;

                    if (!visited[a][cur.b][c]) {
                        visited[a][cur.b][c] = true;
                        queue.add(new Bucket(a, cur.b, c));
                    }
                } else {
                    int a = 0;
                    int c = cur.c + cur.a;
                    if (!visited[a][cur.b][c]) {
                        visited[a][cur.b][c] = true;
                        queue.add(new Bucket(a, cur.b, c));
                    }
                }
            }

            // b 이동
            if (cur.b != 0) {
                //a에서 b로 넣는 경우
                if (cur.b > (limitA - cur.a)) {
                    int b = cur.b - (limitA - cur.a);
                    int a = limitA;

                    if (!visited[a][b][cur.c]) {
                        visited[a][b][cur.c] = true;
                        queue.add(new Bucket(a, b, cur.c));
                    }
                } else {
                    int b = 0;
                    int a = cur.a + cur.b;
                    if (!visited[a][b][cur.c]) {
                        visited[a][b][cur.c] = true;
                        queue.add(new Bucket(a, b, cur.c));
                    }
                }

                //a에서 c로
                if (cur.b > (limitC - cur.c)) {
                    int b = cur.b - (limitC - cur.c);
                    int c = limitC;

                    if (!visited[cur.a][b][c]) {
                        visited[cur.a][b][c] = true;
                        queue.add(new Bucket(cur.a, b, c));
                    }
                } else {
                    int b = 0;
                    int c = cur.c + cur.b;
                    if (!visited[cur.a][b][c]) {
                        visited[cur.a][b][c] = true;
                        queue.add(new Bucket(cur.a, cur.b, c));
                    }
                }
            }

            // c 이동
            if (cur.c != 0) {
                //a에서 b로 넣는 경우
                if (cur.c > (limitB - cur.b)) {
                    int c = cur.c - (limitB - cur.b);
                    int b = limitB;

                    if (!visited[cur.a][b][c]) {
                        visited[cur.a][b][c] = true;
                        queue.add(new Bucket(cur.a, b, c));
                    }
                } else {
                    int c = 0;
                    int b = cur.b + cur.c;
                    if (!visited[cur.a][b][c]) {
                        visited[cur.a][b][c] = true;
                        queue.add(new Bucket(cur.a, b, c));
                    }
                }

                //a에서 c로
                if (cur.c > (limitA - cur.a)) {
                    int c = cur.c - (limitA - cur.a);
                    int a = limitA;

                    if (!visited[a][cur.b][c]) {
                        visited[a][cur.b][c] = true;
                        queue.add(new Bucket(a, cur.b, c));
                    }
                } else {
                    int c = 0;
                    int a = cur.a + cur.c;
                    if (!visited[a][cur.b][c]) {
                        visited[a][cur.b][c] = true;
                        queue.add(new Bucket(a, cur.b, c));
                    }
                }
            }
        }
    }
}
