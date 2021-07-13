package algorithm.baekjun.tree_traversal;

        import java.util.Scanner;

public class Main {
    public static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Node node = new Node(null);

        for (int i=0; i<n; i++) {
            String value =  scanner.next();
            String lValue =  scanner.next();
            String rValue =  scanner.next();

            if (node.value == null) {
                node.value = value;
                node.left = new Node(lValue);
                node.right = new Node(rValue);
            } else {
                createTree(node, value, lValue, rValue);
            }
        }

        preTraversal(node);
        System.out.println();

        inTraversal(node);
        System.out.println();

        postTraversal(node);
    }

    static void createTree(Node root, String value, String lValue, String rValue) {
        if (root == null) return;

        if (root.value.equals(value)) {
            if (!lValue.equals(".")) root.left = new Node(lValue);
            if (!rValue.equals(".")) root.right = new Node(rValue);
        }

        createTree(root.left, value, lValue, rValue);
        createTree(root.right, value, lValue, rValue);
    }

    static void preTraversal(Node root) {
        if (root == null) return;

        if (!root.value.equals(".")) System.out.print(root.value);
        preTraversal(root.left);
        preTraversal(root.right);
    }

    static void inTraversal(Node root){
        if (root == null) return;

        inTraversal(root.left);
        if (!root.value.equals(".")) System.out.print(root.value);
        inTraversal(root.right);
    }

    static void postTraversal(Node root) {
        if (root == null) return;

        postTraversal(root.left);
        postTraversal(root.right);
        if (!root.value.equals(".")) System.out.print(root.value);
    }
}
