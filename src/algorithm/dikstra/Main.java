package algorithm.dikstra;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    static int[] dist;
    static boolean[] visited;
    static int curNode;
    static ArrayList<ArrayList<Node>> list;

    static class Node {
        int vertexNum;
        int weight;

        Node(int vertexNum, int weight) {
            this.vertexNum = vertexNum;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertexNum = Integer.valueOf(scanner.next());
        int edgeNum = Integer.valueOf(scanner.next());

        dist = new int[vertexNum];
        list = new ArrayList<ArrayList<Node>>();
        visited = new boolean[vertexNum];

        int startNum = Integer.valueOf(scanner.next()) - 1;

        for (int i=0; i<vertexNum; i++) {
            if (i == startNum) {
                dist[i] = 0;
            } else {
                dist[i] = INF;
            }

            list.add(new ArrayList<Node>());
            visited[i] = false;
        }

        curNode = startNum;

        for (int i=0; i<edgeNum; i++) {
            int startVertex = Integer.valueOf(scanner.next()) - 1;
            int endVertex = Integer.valueOf(scanner.next()) - 1;
            int weight = Integer.valueOf(scanner.next());

            list.get(startVertex).add(new Node(endVertex, weight));
        }

        // 모든 노드 방문할 때까지 최단 경로를 구한다
        // 현재 방문한 노드의 인접 노드들의 거리를 비교한다
        for (int i=0; i<vertexNum; i++) {
            for (int j=0; j<list.get(curNode).size(); j++) {
                if ((dist[curNode] + list.get(curNode).get(j).weight) < dist[list.get(curNode).get(j).vertexNum]) {
                    dist[list.get(curNode).get(j).vertexNum] = (dist[curNode] + list.get(curNode).get(j).weight);
                }
            }

            visited[curNode] = true;

            int minIdx = 0;
            int min = INF;

            for (int z=0; z < vertexNum; z++) {
                if (visited[z] == false && dist[z] < min) {
                    min = dist[z];
                    minIdx = z;
                }
            }

            curNode = minIdx;
        }

        for (int d: dist) {
            if (d == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d);
            }
        }
    }
}
