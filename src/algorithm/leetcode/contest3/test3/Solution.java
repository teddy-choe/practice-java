package algorithm.leetcode.contest3.test3;

import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        solution.countPaths(7, roads);
    }

    class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    int min = Integer.MAX_VALUE;
    int result = 0;

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adjList.get(road[0]).add(new Node(road[1], road[2]));
            adjList.get(road[1]).add(new Node(road[0], road[2]));
        }

        dfs(adjList, 0, n-1, 0, new boolean[n]);

        return result;
    }

    void dfs(ArrayList<ArrayList<Node>> adjList, int cur, int target, int count, boolean[] visited) {
        if (cur == target) {
            if (min == count) {
                result += 1;
                return;
            } else if (min > count) {
                min = count;
                result = 1;
                return;
            }
        }

        ArrayList<Node> list = adjList.get(cur);
        Iterator<Node> iterator = list.iterator();

        while (iterator.hasNext()) {
            Node next = iterator.next();

            if (!visited[next.index]) {
                visited[next.index] = true;
                dfs(adjList, next.index, target, count + next.value, visited);
                visited[next.index] = false;
            }
        }
    }
}
