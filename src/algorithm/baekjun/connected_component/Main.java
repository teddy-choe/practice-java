package algorithm.baekjun.connected_component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] linkedLists;
    static boolean[] visited;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());

            linkedLists = new LinkedList[n+1];
            visited = new boolean[n+1];

            for (int i=0; i<n; i++) {
                linkedLists[i+1] = new LinkedList<>();
            }

            for (int i=0; i<m; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                linkedLists[a].add(b);
                linkedLists[b].add(a);
            }

            int count = 0;

            for (int i=1; i<linkedLists.length; i++) {
                if (!visited[i]) {
                    count++;
                    dfs(i);
                }
            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int v) {
        visited[v] = true;

        Iterator<Integer> iterator = linkedLists[v].iterator();

        while (iterator.hasNext()) {
            int node = iterator.next();
            if (!visited[node]) dfs(node);
        }
    }
}
