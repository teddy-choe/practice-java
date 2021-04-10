package algorithm.longestNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private boolean[] visited;
    private int[] depths;
    private ArrayList<ArrayList<Integer>> nodeGraph = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();

        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
        int result = main.solution(6, edge);
        System.out.println(result);
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        for (int i=0; i<n; i++) {
            nodeGraph.add(new ArrayList<>());
        }

        for (int i=0; i<edge.length; i++) {
            nodeGraph.get(edge[i][0]-1).add(edge[i][1]-1);
            nodeGraph.get(edge[i][1]-1).add(edge[i][0]-1);
        }

        visited = new boolean[n];
        depths = new int[n];

        bfs(0);

        int count = 0;
        int maxLength = 0;

        for (int i=0; i<depths.length; i++) {
            if (depths[i] == maxLength) {
                count++;
                continue;
            }

            if (depths[i] > maxLength) {
                count = 1;
                maxLength = depths[i];
                continue;
            }
        }

        answer = count;

        return answer;
    }

    public void bfs(int number) {
        Queue <Node> q = new LinkedList();

        q.offer(new Node(number, 0));
        visited[number] = true;

        while(!q.isEmpty()){
            Node temp = q.poll();

            for(int i: nodeGraph.get(temp.number)) {
                if(visited[i] == false){
                    q.offer(new Node(i, temp.depth+1));
                    depths[i] = temp.depth;
                    visited[i] = true;
                }
            }
        }
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
