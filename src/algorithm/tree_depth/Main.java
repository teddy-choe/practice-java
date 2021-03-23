package algorithm.tree_depth;

import java.util.*;

public class Main {
    static List<LinkedList<Integer>> depthList;

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.left.left.left = new Node(2);

        depthList = new ArrayList<>();

        for (int i=0; i<10; i++) {
            depthList.add(new LinkedList<>());
        }

        bfs(root);

        for (LinkedList<Integer> list: depthList) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + ", ");
            }
            System.out.println();
        }
    }

    public static void bfs(Node root) {
        Queue<Depth> queue = new LinkedList<>();

        queue.add(new Depth(root, 0));

        while(!queue.isEmpty()) {
            Depth depthNode = queue.poll();

            depthList.get(depthNode.depth).add(depthNode.node.number);

            if (depthNode.node.left != null) {
                queue.add(new Depth(depthNode.node.left, depthNode.depth+1));
            }

            if (depthNode.node.right != null) {
                queue.add(new Depth(depthNode.node.right, depthNode.depth+1));
            }

        }
    }

    public static class Node {
        int number;
        Node left;
        Node right;

        Node(int number) {
            this.number = number;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static class Depth {
        Node node;
        int depth;

        Depth(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}