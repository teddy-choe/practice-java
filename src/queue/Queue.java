package queue;

class Queue<T> {
    private static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public boolean isEmpty() {
        return head==null;
    }

    public T peek() {
        if (!isEmpty()) {
            return head.data;
        } else {
            throw new NullPointerException();
        }
    }

    public void enqueue(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            Node curNode = head;
            while(curNode.next.next != null) {
                curNode = curNode.next;
            }
            curNode.next = null;
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            Node curNode = head;
            while (curNode!=null) {
                System.out.println(curNode.data);
                curNode = curNode.next;
            }
        }
    }
}
