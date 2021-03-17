package algorithm.path_node;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Graph graph;

    public static void main(String[] args) {
        int vertexNum = 6;

        graph = new Graph(vertexNum);

        graph.put(0, 1);
        graph.put(1, 2);
        graph.put(2, 3);
        graph.put(3, 4);

        search(0);

        for (int i=0; i<vertexNum; i++) {
            if (!graph.isVisited(i)) {
                System.out.println("방문하지 않은 노드 : " + i);
            }
        }
    }

    public static void search(int vertex) {
        graph.setVisited(vertex);
        System.out.println("방문 : " + vertex);

        for (int node: graph.getAdjNode(vertex)) {
            if (!graph.isVisited(node)) {
                search(node);
            }
        }
    }

    public static class Graph {
        private List<List<Integer>> nodeList;
        private boolean[] visited;

        public Graph(int initSize) {
            this.nodeList = new ArrayList<>();
            this.visited = new boolean[initSize];

            for (int i=0; i<initSize; i++) {
                nodeList.add(new ArrayList<>());
            }
        }

        void put(int startVertex, int endVertex) {
            nodeList.get(startVertex).add(endVertex);
            nodeList.get(endVertex).add(startVertex);
        }

        List<Integer> getAdjNode(int vertexNum) {
            return nodeList.get(vertexNum);
        }

        void setVisited(int vertexNum) {
            this.visited[vertexNum] = true;
        }

        boolean isVisited(int vertexNum) {
            return this.visited[vertexNum];
        }
    }
}
