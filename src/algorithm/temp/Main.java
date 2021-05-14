package algorithm.temp;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[] t = {0,0,0,0};
        int[] r = {0,0,0,0};

        int[] result = main.solution(t,r);

        for (int a: result){
            System.out.println(a);
        }
    }

    public class Node implements Comparable<Node> {
        int id;
        int time;
        int rank;

        public Node(int id, int time, int rank) {
            this.id = id;
            this.time = time;
            this.rank = rank;
        }

        @Override
        public int compareTo(Node o) {
            if(this.rank < o.rank) {
                return -1;
            } else if (this.rank > o.rank) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[] solution(int[] t, int[] r) {
        int[] answer = {};

        PriorityQueue<Node> queue = new PriorityQueue<>();
        ArrayList<Node> list = new ArrayList();

        int time = 0;
        while(list.size() != t.length) {
            for(int i=0; i<t.length; i++) {
                if(t[i] == time) {
                    queue.add(new Node(i, t[i], r[i]));
                }
            }

            if(!queue.isEmpty()) {
                list.add(queue.poll());
            }

            time++;
        }

        answer = new int[list.size()];
        int index = 0;

        for(Node n : list) {
            answer[index++] = n.id;
        }

        return answer;
    }
}