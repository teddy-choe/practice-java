package algorithm.baekjun.line_draw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static class Node implements Comparable<Node>{
        long start;
        long end;

        public Node(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.start - o.start);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        ArrayList<Node> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            list.add(new Node(scanner.nextInt(), scanner.nextInt()));
        }

        Collections.sort(list);

        long curStart = 0;
        long curEnd = 0;

        for (Node node : list) {
            if (curEnd >= node.start) {
                // 선분이 겹치므로, 겹치는 선분들의 길이를 비교한다
                if (curEnd < node.end) {
                    curEnd = node.end;
                }
            } else {
                // 새로운 선분을 생성한다
                // 기존 선분은 결과에 더해준다
                answer += curEnd - curStart;

                curStart = node.start;
                curEnd = node.end;
            }
        }

        answer += curEnd - curStart;
        System.out.println(answer);
    }
}
