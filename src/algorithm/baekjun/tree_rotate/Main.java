package algorithm.baekjun.tree_rotate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Node>> nodeArrayList = new ArrayList<>(n+1);

        for (int i=0; i<=n; i++) {
            nodeArrayList.add(new ArrayList<>());
        }

        for (int i=1; i<=n; i++) {
            String[] strings = bufferedReader.readLine().split(" ");

            for (int j=1; j<strings.length-1; j += 2) {
                nodeArrayList.get(i).add(
                        new Node(
                                Integer.parseInt(strings[j]),
                                Integer.parseInt(strings[j+1])
                        )
                );
            }
        }

        for (int i=1; i<=n; i++) {
            bfs(i, nodeArrayList, new boolean[n+1]);
        }

        System.out.println(max);
    }

    static void bfs(int start, ArrayList<ArrayList<Node>> nodeArrayList, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (max < cur.value) {
                max = cur.value;
            }

            Iterator<Node> iterator = nodeArrayList.get(cur.index).iterator();
            while (iterator.hasNext()) {
                Node temp = iterator.next();
                if (!visited[temp.index]) {
                    queue.add(new Node(temp.index, cur.value + temp.value));
                    visited[temp.index] = true;
                }
            }
        }
    }
}
