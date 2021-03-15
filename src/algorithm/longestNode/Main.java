package algorithm.longestNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private boolean[] visited;
    private int[] depths;
    private ArrayList<ArrayList<Integer>> nodeGraph = new ArrayList<>();
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        nodeGraph = new ArrayList<>();
        visited = new boolean[n];
        depths = new int[n];

        for (int i=0; i<n; i++) {
            nodeGraph.add(new ArrayList<>());
        }

        for (int i=0; i<n; i++) {
            int startNode = edge[i][0] - 1;
            int endNode = edge[i][1] - 1;

            nodeGraph.get(startNode).add(endNode);
            nodeGraph.get(endNode).add(startNode);
        }

        visited[0] = true;
        depths[0] = 0;
        Queue<Integer> queue = new LinkedList<>();

        while(!queue.isEmpty()) {
            int number = queue.poll();
            visited[number] = true;

        }

        return answer;
    }

    public class Node {
        int number;
        int depth;

        Node(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }
}
