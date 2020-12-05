package stack;

public class LinkedListStack<D> {
    private static class Node<T> {
        T data;
        Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void push(D data) {
        Node newNode = new Node<D>(data);
        newNode.next = head;
        head = newNode;
    }

    public D pop() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException();

        Node result = head;
        head = head.next;
        return (D) result.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public D peek() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException();

        return (D) head.data;
    }

    public void printStack() {
        int position = 0;
        Node temp = head;

        if (isEmpty()) {
            System.out.println("this stack is Empty!");
        } else {
            do {
                D data = (D) temp.data;
                System.out.println("position: " + position + " data: " + data);
                temp = temp.next;
                position++;
            } while (temp != null);
        }
    }
}
