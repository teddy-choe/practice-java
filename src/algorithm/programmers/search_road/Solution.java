/*
 * 프로그래머스 길 찾기 게임
 * https://programmers.co.kr/learn/courses/30/lessons/42892
 */

package algorithm.programmers.search_road;

import java.util.ArrayList;
import java.util.Collections;

// 트리를 구성하고, 전위, 후위 순회를 구현하면 된다.
// 단, 고려해볼만한 점은 Tree를 구성하는 노드가 x,y 좌표값을 가진다는 점이다.
// 즉, Index를 Value로 설정하고, x와 y값을 통해 Tree의 계층을 형성해야한다.
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        Integer[][] list = solution.solution(nodeInfo);
    }

    class Node implements Comparable<Node>{
        int value;
        Node left;
        Node right;
        int x;
        int y;

        public Node(int value, Node left, Node right, int x, int y) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.x = x;
            this.y = y;
        }

        // 문제의 요구사항에 따라, y값이 큰 노드부터 계층을 형성한다. 같은 y값 내에선, x값이 작은쪽이 먼저 정렬된다.
        @Override
        public int compareTo(Node o) {
            if (this.y < o.y) {
                return 1;
            } else if (this.y == o.y) {
                if (this.x > o.x) {
                    return 1;
                }
            }

            return -1;
        }
    }

    public Integer[][] solution(int[][] nodeinfo) {
        ArrayList<Node> nodeArrayList = new ArrayList<>();

        for (int i=0; i<nodeinfo.length; i++) {
            nodeArrayList.add(new Node(i+1, null, null, nodeinfo[i][0], nodeinfo[i][1]));
        }

        // 계층을 차례대로 형성하기 위해, 기준에 따라 정렬한다.
        Collections.sort(nodeArrayList);

        for (int i=1; i<nodeArrayList.size(); i++) {
            createNode(nodeArrayList.get(0), nodeArrayList.get(i));
        }

        ArrayList<Integer> traverseList = new ArrayList<>();
        Integer[][] result = new Integer[2][nodeArrayList.size()];

        // 전위 순회한다
        preTraversal(nodeArrayList.get(0), traverseList);
        result[0] = traverseList.toArray(result[0]);

        // 후위 순회한다
        postTraversal(nodeArrayList.get(0), traverseList);
        result[1] = traverseList.toArray(result[1]);

        return result;
    }

    void createNode(Node root, Node child) {
        // 노드의 x값을 기준으로 대소관계를 비교한다. 이진 탐색 트리와 흡사하다
        if (root.x > child.x) {
            if (root.left != null) {
                createNode(root.left, child);
            } else {
                root.left = child;
            }
        } else {
            if (root.right != null) {
                createNode(root.right, child);
            } else {
                root.right = child;
            }
        }
    }

    void preTraversal(Node head, ArrayList<Integer> preList) {
        if (head == null) return;

        preList.add(head.value);
        preTraversal(head.left, preList);
        preTraversal(head.right, preList);
    }

    void postTraversal(Node head, ArrayList<Integer> postList) {
        if (head == null) return;

        postTraversal(head.left, postList);
        postTraversal(head.right, postList);
        postList.add(head.value);
    }
}
