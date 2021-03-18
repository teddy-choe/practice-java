package algorithm.shortestTree;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};

        int mid = array.length / 2;
        Node node = makeTree(array, array[mid], 0, array.length);
    }

    public static Node makeTree(int[] array, int data, int start, int end) {
        if (start>=end) {
            return null;
        }

        Node root = new Node(data);
        int mid = (start+end) / 2;

        root.left = makeTree(array, array[mid] , start, mid);
        root.right = makeTree(array, array[mid] , mid+1, end);

        return root;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
