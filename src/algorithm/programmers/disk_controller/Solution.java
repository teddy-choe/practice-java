package algorithm.programmers.disk_controller;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{1, 9}, {0, 3}, {2, 6}};
        System.out.println(solution.solution(jobs));
    }

    class Node implements Comparable<Node>{
        int startTime;
        int operation;

        public Node(int startTime, int operation) {
            this.startTime = startTime;
            this.operation = operation;
        }

        @Override
        public int compareTo(Node o) {
            if (this.operation > o.operation) {
                return 1;
            } else if (this.operation < o.operation) {
                return -1;
            } else {
                if (this.startTime > o.startTime) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        int time = 0;
        int sum = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        LinkedList<Node> queue = new LinkedList<>();

        for (int[] job : jobs) {
            queue.add(new Node(job[0], job[1]));
        }

        Collections.sort(queue, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.startTime - o2.startTime;
            }
        });

        Node node = queue.poll();
        priorityQueue.add(node);

        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            time += cur.operation;
            sum += time - cur.startTime;

            while (!queue.isEmpty() && queue.peek().startTime <= time) {
                priorityQueue.add(queue.poll());
            }
        }

        answer = sum / jobs.length;

        return answer;
    }
}
