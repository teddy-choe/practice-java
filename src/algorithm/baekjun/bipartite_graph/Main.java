package algorithm.baekjun.bipartite_graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int[] color;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i=0; i<n; i++) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();
            adjList = new LinkedList[v+1];
            visited = new boolean[v+1];
            color = new int[v+1];

            for (int j=1; j<=v; j++) {
                adjList[j] = new LinkedList<>();
            }

            for (int j=0; j<e; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                adjList[start].add(end);
                adjList[end].add(start);
            }

            boolean result = true;

            for (int w=1; w<=v; w++) {
                if (!visited[w]) {
                    result = bfs(w);
                }

                if (!result) {
                    break;
                }
            }

            if (!result) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean isBipartite = true;
        queue.add(start);
        visited[start] = true;
        // color white
        color[start] = 1;

        while (!queue.isEmpty()) {
            Integer num = queue.poll();

            Iterator<Integer> iterator = adjList[num].iterator();
            while (iterator.hasNext()) {
                Integer cur = iterator.next();
                if (!visited[cur]) {
                    // 인접 노드에 대해 방문하지 않은 경우
                    visited[cur] = true;
                    // 반대 색상을 입력한다
                    color[cur] = 1 - color[num];
                    queue.add(cur);
                } else {
                    if (color[cur] == color[num]) {
                        isBipartite = false;
                        break;
                    }
                }
            }
        }

        return isBipartite;
    }
}
