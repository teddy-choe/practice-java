package binary_tree;

public class BinaryTree<D> {
    private static class Node<T> {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node head;

    public BinaryTree(D data) {
        head = new Node(data);
    }

    public void setLeft(Node<D> curNode, D data) {
        Node newNode = new Node(data);

        if (curNode.left != null) {
            newNode.left = curNode.left;
        }
        curNode.left = newNode;
    }

    public void setRight(Node<D> curNode, D data) {
        Node newNode = new Node(data);

        if (curNode.right != null) {
            newNode.right = curNode.right;
        }
        curNode.right = newNode;
    }

    public Node getLeft(Node<D> curNode) {
        if (curNode.left == null) throw new NullPointerException();

        return curNode.left;
    }

    public Node getRight(Node<D> curNode) {
        if (curNode.right == null) throw new NullPointerException();

        return curNode.right;
    }

    public Node getHead() {
        return this.head;
    }

    public D getValue(Node<D> curNode) {
        return curNode.data;
    }

    public void inOrder(Node<D> curNode) {
        if (curNode != null) {
            inOrder(curNode.left);
            System.out.println(curNode.data);
            inOrder(curNode.right);
        }
    }

    public void preOrder(Node<D> curNode) {
        if (curNode != null) {
            System.out.println(curNode.data);
            preOrder(curNode.left);
            preOrder(curNode.right);
        }
    }

    public void postOrder(Node<D> curNode) {
        if (curNode != null) {
            postOrder(curNode.left);
            postOrder(curNode.right);
            System.out.println(curNode.data);
        }
    }
}
