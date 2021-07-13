package algorithm.baekjun.parent_node;

import java.util.Scanner;

public class Main {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    static int[] parentList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        parentList = new int[n];
        Node root = new Node(1);

        for (int i=0; i<n-1; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            createNode(root, first, second);
        }

        for (int i=1; i<n; i++) {
            System.out.println(parentList[i]);
        }
    }

    static void createNode(Node node, int first, int second) {
        if (node == null) return;

        if (node.value == first) {
            if (node.left == null) node.left = new Node(second);
            else node.right = new Node(second);

            parentList[second-1] = first;
        } else if (node.value == second) {
            if (node.left == null) node.left = new Node(first);
            else node.right = new Node(first);

            parentList[first-1] = second;
        } else {
            createNode(node.left, first, second);
            createNode(node.right, first, second);
        }
    }
}
